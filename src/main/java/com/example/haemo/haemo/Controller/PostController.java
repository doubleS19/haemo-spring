package com.example.haemo.haemo.Controller;

import com.example.haemo.haemo.Data.Post;
import com.example.haemo.haemo.Data.User;
import com.example.haemo.haemo.Repository.PostRepository;
import com.example.haemo.haemo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("postUser/{id}")
    @ResponseBody
    public User getUserByPost(@PathVariable Long id){
        Post post = getPostById(id).getBody();
        assert post != null;
        String userNick = post.getNickname();

        User user = userController.getUserByNickname(userNick);
        return user;
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
