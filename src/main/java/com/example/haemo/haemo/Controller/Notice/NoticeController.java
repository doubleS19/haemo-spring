package com.example.haemo.haemo.Controller.Notice;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Notice.Notice;
import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Notice.NoticeRepository;
import com.example.haemo.haemo.Repository.Post.PostRepository;
import com.example.haemo.haemo.Service.Notice.NoticeService;
import com.example.haemo.haemo.Service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Notice> saveNotice(@RequestBody Notice notice) {
        Notice savedPost = noticeService.savePost(notice);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Notice> getAllPost() {
        return noticeRepository.findAll();
    }

    @PostMapping(value = "/visibility", produces = "application/json")
    @ResponseBody
    public void changeNoticeVisible(@RequestBody Notice notice) {
        noticeService.changeNoticeVisibility(notice);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Notice> getPostById(@PathVariable Long id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        return noticeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
