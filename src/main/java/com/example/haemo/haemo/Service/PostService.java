package com.example.haemo.haemo.Service;

import com.example.haemo.haemo.Data.Post;
import com.example.haemo.haemo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
