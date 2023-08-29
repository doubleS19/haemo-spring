package com.example.haemo.haemo.Controller.Notice;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Notice.Notice;
import com.example.haemo.haemo.Repository.Notice.NoticeRepository;
import com.example.haemo.haemo.Service.Notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/visible/{nId}")
//    @ResponseBody
//    public Notice changeNoticeVisible(@PathVariable Long nId) {
//        return noticeService.changeNoticeVisibility(
//                nId
//        );
//    }

    @PutMapping("/visible/{nId}")
    public ResponseEntity<String> changeNoticeVisible(@PathVariable Long nId) throws ChangeSetPersister.NotFoundException {
        // Find the notice by ID
       noticeService.changeNoticeVisibility(nId);

        return ResponseEntity.ok("Notice visibility toggled successfully");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Notice> getPostById(@PathVariable Long id) {
        Optional<Notice> noticeOptional = noticeRepository.findById(id);
        return noticeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
