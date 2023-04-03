package com.example.haemo.haemo.Service;

import com.example.haemo.haemo.Data.User;
import com.example.haemo.haemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User person) {
        User savedPerson = userRepository.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }
}
