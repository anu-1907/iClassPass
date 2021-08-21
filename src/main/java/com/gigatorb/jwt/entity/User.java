package com.gigatorb.jwt.entity;

<<<<<<< HEAD
import lombok.*;

import javax.persistence.*;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column @Getter  @Setter
    private String name;

    @Column @Getter @Setter
    private String email;

    @Column @Getter @Setter
    private String contact;

    @Column @Getter @Setter
    private String password;

    public User(String userName, String encodedPass) {
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", role='" + role + '\'' +
//                '}';
//    }
=======
    private int id;
    private String username;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
}
