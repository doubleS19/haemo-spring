package com.example.haemo.haemo.Repository;

import com.example.haemo.haemo.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}