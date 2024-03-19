package com.example.haemo.haemo.Controller.Reply.Post;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.Reply.Post.Reply;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Reply.Post.ReplyRepository;
import com.example.haemo.haemo.Service.Reply.Post.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/postReply")
public class ReplyController {

    @Autowired
    private ReplyService commentService;

    private final ReplyRepository commentRepository;

    @Autowired
    public ReplyController(ReplyRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Reply> saveComment(@RequestBody Reply comment) {
        Reply savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Reply> getCommentById(@PathVariable Long id) {
        Optional<Reply> commentById = commentRepository.findById(id);
        return commentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("commentPost/{cId}")
    @ResponseBody
    public List<Reply> getCommentsByPId(@PathVariable Long cId) {
        return commentRepository.findAllBycId(cId);
    }

    @GetMapping("commentUser/{id}")
    @ResponseBody
    public User getUserByComment(@PathVariable Long id) {
        Reply comment = getCommentById(id).getBody();
        assert comment != null;
        String userNick = comment.getNickname();

        return userController.getUserByNickname(userNick);
    }
}
