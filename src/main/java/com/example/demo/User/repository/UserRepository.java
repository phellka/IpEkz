package com.example.demo.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.User.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLoginIgnoreCase(String login);
}