package com.gigatorb.jwt.repository;

import com.gigatorb.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
=======


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
}
