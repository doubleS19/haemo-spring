package com.example.haemo.haemo.Repository.User;

import com.example.haemo.haemo.Data.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByNickname(String nickname);

    public Boolean existsByNickname(String Nickname);
}