package com.example.haemo.haemo.Service.User;

import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByNickname(String nickname){
        User findedUser = userRepository.findByNickname(nickname);

        return findedUser;
    }

    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);
    }
}