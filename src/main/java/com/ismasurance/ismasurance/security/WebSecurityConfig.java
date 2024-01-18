package com.ismasurance.ismasurance.security;

import com.ismasurance.ismasurance.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// Spring Security main configuration class
@Configuration
public class WebSecurityConfig {

    /*
    Get a UserService object to check if an account that
    matches the email sent exists in DB.
    */
    private static final String USER_LOGIN_STRING = "/user/login";
    private static final String URL_LOCAL = "http://localhost:3000";
    private static final String AUTHORIZATION_TXT = "Authorization";

    private final UserService userService;

    /*
    Get the AuthorizationFilter to filter the request in
    order to get the access token.
    */
    private final AuthorizationFilter authenticationFiler;

    public WebSecurityConfig(UserService userService, AuthorizationFilter authenticationFiler) {
        this.userService = userService;
        this.authenticationFiler = authenticationFiler;
    }

    /*
    Make the filter that imports the filter to manage the request
    in order to authenticate the user.
    */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager)
            throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager);
        authenticationFilter.setAuthenticationManager(authenticationManager);
        authenticationFilter.setFilterProcessesUrl(USER_LOGIN_STRING);

    /*
    Returns the filter that matches against the http request
    filters it to authenticate the user.
    It disables the csrf to avoid that it will cloak the JWT
    authentication. Also, it permits all request just for
    authenticated users, but /login permits all requests without
    authentication. It manages the session creating one if any
    is already created and passes the filters before build the chain.
    */
        return http
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(USER_LOGIN_STRING)
                .permitAll()
                .antMatchers("/claim/newClaim")
                .permitAll()
                .antMatchers("/claim/searchClaim")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(authenticationFilter)
                .addFilterBefore(authenticationFiler, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    /*
    Instantiate the manager that handles the authentication
    process for the user, checking its existence with the
    password matching function with the encoder.
     */
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(this.userService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    /*
    Create a password encoder for the user's password using
    BCrypt password-hashing function.
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer customConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                configurer.defaultContentType(MediaType.APPLICATION_JSON);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(USER_LOGIN_STRING).allowedOrigins(URL_LOCAL).exposedHeaders(AUTHORIZATION_TXT);
                registry.addMapping("/logout").allowedOrigins(URL_LOCAL);
            }

            @Bean
            public CorsConfigurationSource corsConfigurationSource() {
                final CorsConfiguration configuration = new CorsConfiguration();
                List<String> origins = new java.util.ArrayList<>();
                origins.add("*");
                configuration.setAllowedOrigins(origins);
                List<String> allowedMethods = new java.util.ArrayList<>();
                allowedMethods.add("HEAD");
                allowedMethods.add("GET");
                allowedMethods.add("POST");
                allowedMethods.add("PUT");
                allowedMethods.add("DELETE");
                allowedMethods.add("PATCH");
                configuration.setAllowedMethods(allowedMethods);
                // setAllowCredentials(true) is important, otherwise:
                // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
                configuration.setAllowCredentials(true);
                // setAllowedHeaders is important! Without it, OPTIONS preflight request
                // will fail with 403 Invalid CORS request
                List<String> allowedHeaders = new java.util.ArrayList<>();
                allowedHeaders.add(AUTHORIZATION_TXT);
                allowedHeaders.add("Cache-Control");
                allowedHeaders.add("Content-Type");
                configuration.setAllowedHeaders(allowedHeaders);
                configuration.addExposedHeader(AUTHORIZATION_TXT);
                final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                return source;
            }
        };
    }
}
