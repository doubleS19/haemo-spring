package com.example.haemo.haemo.Controller;

import com.example.haemo.haemo.Data.ClubPost;
import com.example.haemo.haemo.Data.User;
import com.example.haemo.haemo.Repository.ClubPostRepository;
import com.example.haemo.haemo.Service.ClubPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
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

//
//    public List<Post> get24HoursPosts() {
//        LocalDateTime twentyFourHoursLeft = LocalDateTime.now().plusHours(24);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시");
//
//        List<Post> recentPosts = postRepository.findAll().stream()
//                .filter(post -> {
//                    LocalDateTime postDate = LocalDateTime.parse(post.getDate(), formatter);
//                    return postDate.isAfter(twentyFourHoursLeft);
//                })
//                .collect(Collectors.toList());
//
//        return recentPosts;
//    }
}
