package com.example.haemo.haemo.Controller.User;

import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.User.UserRepository;
import com.example.haemo.haemo.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(produces = "application/json")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{nickname}")
    @ResponseBody
    public User getUserByNickname(@PathVariable String nickname) {
        User findedUser = userService.findUserByNickname(nickname);
        return findedUser;
    }
}