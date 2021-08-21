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
<<<<<<< HEAD
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
=======
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
        if(user == null){
            throw new UsernameNotFoundException("User Not Found.");
        }
        return new CustomUserDetails(user);
    }
<<<<<<< HEAD

    public User saveUser(User users) throws UsernameNotFoundException {
        User user = new User();
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        user.setName(users.getName());
        user.setContact(users.getContact());
        userRepository.save(user);
        return user;

    }
=======
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
}
