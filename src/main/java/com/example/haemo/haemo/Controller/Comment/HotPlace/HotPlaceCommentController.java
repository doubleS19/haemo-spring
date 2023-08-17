package com.example.haemo.haemo.Controller.Comment.HotPlace;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Comment.HotPlace.HotPlaceCommentRepository;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import com.example.haemo.haemo.Service.Comment.HotPlace.HotPlaceCommentService;
import com.example.haemo.haemo.Service.Comment.Post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/hotComment")
public class HotPlaceCommentController {

    @Autowired
    private HotPlaceCommentService commentService;

    private final HotPlaceCommentRepository commentRepository;

    @Autowired
    public HotPlaceCommentController(HotPlaceCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<HotPlaceComment> saveComment(@RequestBody HotPlaceComment comment) {
        HotPlaceComment savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HotPlaceComment> getCommentById(@PathVariable Long id) {
        Optional<HotPlaceComment> commentById = commentRepository.findById(id);
        return commentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("commentPost/{pId}")
    @ResponseBody
    public List<HotPlaceComment> getCommentsByPId(@PathVariable Long pId) {
        return commentRepository.findAllBypId(pId);
    }

    @GetMapping("commentUser/{id}")
    @ResponseBody
    public User getUserByComment(@PathVariable Long id) {
        HotPlaceComment comment = getCommentById(id).getBody();
        assert comment != null;
        String userNick = comment.getNickname();

        return userController.getUserByNickname(userNick);
    }
}
