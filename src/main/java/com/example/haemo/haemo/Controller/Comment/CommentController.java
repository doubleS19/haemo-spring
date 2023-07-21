package com.example.haemo.haemo.Controller.Comment;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.Comment;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.CommentRepository;
import com.example.haemo.haemo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

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

    @GetMapping("/commentPost/{pid}")
    @ResponseBody
    public List<Comment> getAllCommentByPId(@PathVariable Long pId) {
        List<Comment> commentList = commentRepository.findAll();
        List<Comment> wantedComment = new ArrayList<>();

        for (Comment comment : commentList){
            Long commentPId = comment.getPId();
            if (commentPId.equals(pId)){
                wantedComment.add(comment);
            }
        }

        return wantedComment;
    }

    @GetMapping("commentUser/{id}")
    @ResponseBody
    public User getUserByComment(@PathVariable Long id) {
        Comment comment = getCommentById(id).getBody();
        assert comment != null;
        String userNick = comment.getNickname();

        return userController.getUserByNickname(userNick);
    }
}
