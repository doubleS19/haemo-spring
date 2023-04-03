package com.example.haemo.haemo.Controller;

import com.example.haemo.haemo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("test")
    @ResponseBody
    public void getPostData(@RequestParam("pId") Long pId,
                      @RequestParam("title") String title,
                      @RequestParam("content") String content,
                      @RequestParam("nickname") String nickname,
                      @RequestParam("person") String person,
                      @RequestParam("category") String category) {
        return;
    }
}
