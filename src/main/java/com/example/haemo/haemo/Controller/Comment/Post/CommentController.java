package com.example.haemo.haemo.Controller.Comment.Post;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import com.example.haemo.haemo.Service.Comment.Post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/postComment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> commentById = commentRepository.findById(id);
        return commentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("commentPost/{pId}")
    @ResponseBody
    public List<Comment> getCommentsByPId(@PathVariable Long pId) {
        return commentRepository.findAllBypId(pId);
    }

//    @GetMapping("commentUser/{id}")
//    @ResponseBody
//    public User getUserByComment(@PathVariable Long id) {
//        Comment comment = getCommentById(id).getBody();
//        assert comment != null;
//        String userNick = comment.getNickname();
//
//        return userController.getUserByNickname(userNick);
//    }

    @GetMapping("commentUser/{pId}")
    @ResponseBody
    public List<User> getCommentUserByCpId(@PathVariable Long pId) {
        return commentService.getCommentUserList(pId);
    }
}
