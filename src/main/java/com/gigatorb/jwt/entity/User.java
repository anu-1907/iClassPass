package com.gigatorb.jwt.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
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
}
