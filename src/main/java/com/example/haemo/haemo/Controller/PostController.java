package com.example.haemo.haemo.Controller;

import com.example.haemo.haemo.Data.Post;
import com.example.haemo.haemo.Data.PostDto;
import com.example.haemo.haemo.Repository.PostRepository;
import com.example.haemo.haemo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<PostDto> fetchPost(){
        return postService.allCashBoardEntity();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
            Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    @ResponseBody
//    public ResponseEntity<Post> getPostById(@RequestBody PostDto postDto) {
//        Post post = new Post();
//            Optional<Post> postOptional = postRepository.findById(postDto.getPId());
//            return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//
//    }
}
