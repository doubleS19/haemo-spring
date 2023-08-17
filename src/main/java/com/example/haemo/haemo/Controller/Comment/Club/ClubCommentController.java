package com.example.haemo.haemo.Controller.Comment.Club;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Comment.Club.ClubCommentRepository;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import com.example.haemo.haemo.Service.Comment.Club.ClubCommentService;
import com.example.haemo.haemo.Service.Comment.Post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clubComment")
public class ClubCommentController {

    @Autowired
    private ClubCommentService commentService;

    private final ClubCommentRepository commentRepository;

    @Autowired
    public ClubCommentController(ClubCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<ClubComment> saveComment(@RequestBody ClubComment comment) {
        ClubComment savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ClubComment> getCommentById(@PathVariable Long id) {
        Optional<ClubComment> commentById = commentRepository.findById(id);
        return commentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("commentPost/{cpId}")
    @ResponseBody
    public List<ClubComment> getCommentsByCpId(@PathVariable Long cpId) {
        return commentRepository.findAllByCpId(cpId);
    }

    @GetMapping("commentUser/{id}")
    @ResponseBody
    public User getUserByComment(@PathVariable Long id) {
        ClubComment comment = getCommentById(id).getBody();
        assert comment != null;
        String userNick = comment.getNickname();

        return userController.getUserByNickname(userNick);
    }
}
