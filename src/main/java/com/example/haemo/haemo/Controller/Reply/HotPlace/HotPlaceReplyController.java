package com.example.haemo.haemo.Controller.Reply.HotPlace;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Reply.HotPlace.HotPlaceReply;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Comment.HotPlace.HotPlaceCommentRepository;
import com.example.haemo.haemo.Repository.Reply.HotPlace.HotPlaceReplyRepository;
import com.example.haemo.haemo.Service.Comment.HotPlace.HotPlaceCommentService;
import com.example.haemo.haemo.Service.Reply.HotPlace.HotPlaceReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/hotReply")
public class HotPlaceReplyController {

    @Autowired
    private HotPlaceReplyService commentService;

    private final HotPlaceReplyRepository commentRepository;

    @Autowired
    public HotPlaceReplyController(HotPlaceReplyRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<HotPlaceReply> saveComment(@RequestBody HotPlaceReply comment) {
        HotPlaceReply savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HotPlaceReply> getCommentById(@PathVariable Long id) {
        Optional<HotPlaceReply> commentById = commentRepository.findById(id);
        return commentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("commentPost/{hcId}")
    @ResponseBody
    public List<HotPlaceReply> getCommentsByHpId(@PathVariable Long hcId) {
        return commentRepository.findAllByHcId(hcId);
    }

    @GetMapping("commentUser/{id}")
    @ResponseBody
    public User getUserByComment(@PathVariable Long id) {
        HotPlaceReply comment = getCommentById(id).getBody();
        assert comment != null;
        String userNick = comment.getNickname();

        return userController.getUserByNickname(userNick);
    }
}
