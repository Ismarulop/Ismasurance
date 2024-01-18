//package com.ismasurance.ismasurance.user.data;
//
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@Entity(name = "users")
//public class UserEntity {
//
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", nullable = false)
//    private long id;
//
//    @Column(nullable = false)
//    private String userId;
//
//    @Column(nullable = false, length = 50)
//    private String userName;
//
//    @Column(nullable = false, length = 50)
//    private String firstName;
//
//    @Column(nullable = false, length = 50)
//    private String lastName;
//
//    @Column(nullable = false, length = 255)
//    private String email;
//
//    @Column(nullable = false)
//    private String encryptedPassword;
//
//     @Column(nullable = true)
//    private String phone;
//
//     @Column(nullable = true)
//    private String countryCode;
//
//     @Column(nullable = true)
//    private String country;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//}
