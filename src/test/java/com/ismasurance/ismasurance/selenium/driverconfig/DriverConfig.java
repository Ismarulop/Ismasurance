package com.ismasurance.ismasurance.selenium.driverconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan
public class DriverConfig {

    @Bean
    public WebDriver DriverConfig(){
        System.setProperty("webdriver.chrome.driver","C:/dev/Selenium/chromedriver_win32/chromedriver.exe");
        WebDriver webDriver= new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        return webDriver;
    }
}
