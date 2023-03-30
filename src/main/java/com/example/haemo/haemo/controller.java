package com.example.haemo.haemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class controller {

    @Autowired
    PosttService testService;

    @GetMapping("test")
    @ResponseBody
    public void gkatn(@RequestParam("pId") Integer pId,
    @RequestParam("title") String title,
    @RequestParam("content") String content,
    @RequestParam("nickname") String nickname,
    @RequestParam("person") Integer person,
    @RequestParam("category") String category){
        testService.test(pId, title, content, nickname, person, category);
        return;
    }
}
