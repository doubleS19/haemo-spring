package com.example.haemo.haemo.Controller.Club;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.ClubPost.ClubPost;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.ClubPost.ClubPostRepository;
import com.example.haemo.haemo.Service.ClubPost.ClubPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/club")
public class ClubPostController {

    @Autowired
    private ClubPostService postService;

    @Autowired
    private ClubPostRepository postRepository;

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<ClubPost> saveClubPost(@RequestBody ClubPost post) {
        ClubPost savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<ClubPost> getAllClubPost() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ClubPost> getClubPostById(@PathVariable Long id) {
        Optional<ClubPost> postOptional = postRepository.findById(id);
        return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("clubPostUser/{id}")
    @ResponseBody
    public User getUserByClubPost(@PathVariable Long id) {
        ClubPost post = getClubPostById(id).getBody();
        assert post != null;
        String userNick = post.getNickname();

        User user = userController.getUserByNickname(userNick);
        return user;
    }
}
