package com.example.haemo.haemo.Controller;

import com.example.haemo.haemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    public void getUserData(@RequestParam("uId") Long uId,
                      @RequestParam("nickname") String nickname,
                      @RequestParam("major") String major,
                      @RequestParam("gender") String gender) {
        return;
    }
}