package com.example.haemo.haemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    void test(Integer pId,
              String title,
              String content,
              String nickname,
              Integer person,
              String category) {
        Post post = new Post(pId, title, content, nickname, person, category);


        postRepository.save(post);
    }
}
