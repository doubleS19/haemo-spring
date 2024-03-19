package com.example.haemo.haemo.Controller.Reply.Club;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Reply.Club.ClubReply;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Reply.Club.ClubReplyRepository;
import com.example.haemo.haemo.Service.Reply.Club.ClubReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clubReply")
public class ClubReplyController {

    @Autowired
    private ClubReplyService commentService;

    private final ClubReplyRepository commentRepository;

    @Autowired
    public ClubReplyController(ClubReplyRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<ClubReply> saveComment(@RequestBody ClubReply comment) {
        ClubReply savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ClubReply> getCommentById(@PathVariable Long id) {
        Optional<ClubReply> commentById = commentRepository.findById(id);
        return commentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("commentPost/{ccId}")
    @ResponseBody
    public List<ClubReply> getCommentsByCpId(@PathVariable Long ccId) {
        return commentRepository.findAllByCcId(ccId);
    }

    @GetMapping("commentUser/{id}")
    @ResponseBody
    public User getUserByComment(@PathVariable Long id) {
        ClubReply comment = getCommentById(id).getBody();
        assert comment != null;
        String userNick = comment.getNickname();

        return userController.getUserByNickname(userNick);
    }
}
