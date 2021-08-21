package com.gigatorb.jwt.util;

import com.gigatorb.jwt.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
<<<<<<< HEAD
        return Collections.emptyList();    }
=======
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
<<<<<<< HEAD
        return user.getEmail();
=======
        return user.getUsername();
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
