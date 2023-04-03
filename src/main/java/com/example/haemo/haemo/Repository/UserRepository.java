package com.example.haemo.haemo.Repository;

import com.example.haemo.haemo.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}