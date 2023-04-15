package com.example.haemo.haemo.Repository;

import com.example.haemo.haemo.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByNickname(String nickname);
}