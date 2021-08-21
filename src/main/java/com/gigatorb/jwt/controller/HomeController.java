package com.gigatorb.jwt.controller;

<<<<<<< HEAD
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;

import com.gigatorb.jwt.model.JwtRequest;
import com.gigatorb.jwt.model.JwtResponse;
import com.gigatorb.jwt.repository.UserRepository;
import com.gigatorb.jwt.service.CustomUserDetailsService;
import com.gigatorb.jwt.util.CustomUserDetails;
import com.gigatorb.jwt.util.JWTUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import com.gigatorb.jwt.entity.User;


import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;


@RestController
@CrossOrigin(origins ="http://localhost:3000")

=======
import com.gigatorb.jwt.model.JwtRequest;
import com.gigatorb.jwt.model.JwtResponse;
import com.gigatorb.jwt.service.CustomUserDetailsService;
import com.gigatorb.jwt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
public class HomeController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
<<<<<<< HEAD
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    public PasswordEncoder passwordEncoder;
=======

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3

    @GetMapping("/home")
    public String home(){
        return "Welcome, This is user page.";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome, This is admin page.";
    }

<<<<<<< HEAD
    @PostMapping( "/")
    public JwtResponse googleApi(@RequestBody JSONObject idTokenString ) throws GeneralSecurityException, IOException {
        final String CLIENT_ID = "897936785153-9nvngsr3m32mbal4sm7h9m3fiotj7u7r.apps.googleusercontent.com";


        JSONObject jsonObject = new JSONObject();
        jsonObject = idTokenString;
        String gToken = jsonObject.getAsString("token");



        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(CLIENT_ID))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();


// (Receive idTokenString by HTTPS POST)

        GoogleIdToken idToken = verifier.verify(gToken);

        if (idToken != null) {
            Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
//            String pictureUrl = (String) payload.get("picture");
//            String locale = (String) payload.get("locale");
//            String familyName = (String) payload.get("family_name");
//            String givenName = (String) payload.get("given_name");
            if (userRepository.findByEmail(email) != null) {
                final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                        email);
                final String token = jwtUtil.generateToken(userDetails);

                return new JwtResponse(token);


            } else {
                String userName = name;


                User user = new User();
                user.setEmail(email);
                user.setName(userName);
                customUserDetailsService.saveUser(user);
                final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                        email);
                final String token = jwtUtil.generateToken(userDetails);

                return new JwtResponse(token);

            }

        } else {
            return new JwtResponse("bad response");

        }
    }
    @PostMapping("/fbApi")
    public JwtResponse fbApi(@RequestBody JSONObject idToken ) throws GeneralSecurityException, IOException{
        JSONObject jsonObject=idToken;
        Map<String,Object> token=(Map<String, Object>) jsonObject.get("token");
        String name = token.get("name").toString();
        String email = token.get("email").toString();

        if (userRepository.findByEmail(email) != null) {
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                    email.toString());
            final String tokens = jwtUtil.generateToken(userDetails);

            return new JwtResponse(tokens);


        }else {
            String userName = name;

            User user = new User();
            user.setEmail(email);
            user.setName(userName);
            customUserDetailsService.saveUser(user);
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                    email.toString());
            final String tokens = jwtUtil.generateToken(userDetails);

            return new JwtResponse(tokens);

        }



    }


=======
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
<<<<<<< HEAD
                            jwtRequest.getEmail(),
=======
                            jwtRequest.getUsername(),
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
                            jwtRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException ex){
            throw new Exception("Bad Credential Exception", ex);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
<<<<<<< HEAD
                jwtRequest.getEmail());
        final String token = jwtUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }

    @PostMapping("/signup")
    public JwtResponse registerUser(@RequestBody JwtRequest signUpRequest) {
        if (userRepository.findByEmail(signUpRequest.getEmail())!=null) {
            return new JwtResponse("Already in use") ;
        }


//         Create new user's account
        String email=signUpRequest.getEmail();
        String name=signUpRequest.getName();


        String contact=signUpRequest.getContact();


        String encodedPass = passwordEncoder.encode(signUpRequest.getPassword());

        User user = new User();

        user.setEmail(email);
        user.setName(name);
        user.setContact(contact);

        user.setPassword(encodedPass);
        customUserDetailsService.saveUser(user);
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                name);
        final String token = jwtUtil.generateToken(userDetails);

        return new JwtResponse(token);




    }
}

=======
                jwtRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
