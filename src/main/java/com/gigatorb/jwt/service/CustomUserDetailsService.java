package com.gigatorb.jwt.service;

import com.gigatorb.jwt.util.CustomUserDetails;
import com.gigatorb.jwt.entity.User;
import com.gigatorb.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found.");
        }
        return new CustomUserDetails(user);
    }

    public User saveUser(User users) throws UsernameNotFoundException {
        User user = new User();
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        user.setName(users.getName());
        user.setContact(users.getContact());
        userRepository.save(user);
        return user;

    }
}
