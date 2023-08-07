package com.example.haemo.haemo.Controller.HotPlace;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.HotPlace.HotPlaceRepository;
import com.example.haemo.haemo.Service.HotPlace.HotPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/hot")
public class HotPlaceController {

    @Autowired
    private HotPlaceService postService;

    @Autowired
    private HotPlaceRepository postRepository;

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<HotPlace> saveHotPlacePost(@RequestBody HotPlace post) {
        HotPlace savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<HotPlace> getAllHotPlacePost() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HotPlace> getHotPlaceById(@PathVariable Long id) {
        Optional<HotPlace> postOptional = postRepository.findById(id);
        return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("hotPlaceUser/{id}")
    @ResponseBody
    public User getUserByClubPost(@PathVariable Long id) {
        HotPlace post = getHotPlaceById(id).getBody();
        assert post != null;
        String userNick = post.getNickname();

        User user = userController.getUserByNickname(userNick);
        return user;
    }
}
