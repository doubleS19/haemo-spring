package com.example.haemo.haemo.Repository.User;

import com.example.haemo.haemo.Data.User.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    public Login findByNickname(String nickname);

    public Boolean existsByNickname(String Nickname);
}