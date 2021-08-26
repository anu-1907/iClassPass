package com.gigatorb.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String name;
    private String email;
    private String contact;
    private String password;


}
