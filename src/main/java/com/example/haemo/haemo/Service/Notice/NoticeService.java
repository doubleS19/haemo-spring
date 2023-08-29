package com.example.haemo.haemo.Service.Notice;

import com.example.haemo.haemo.Data.Notice.Notice;
import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Repository.Notice.NoticeRepository;
import com.example.haemo.haemo.Repository.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;


    public NoticeService(NoticeRepository postRepository) {
        this.noticeRepository = postRepository;

    }

    public Notice savePost(Notice notice) {
        return noticeRepository.save(notice);
    }

    public void changeNoticeVisibility(Long nId) throws ChangeSetPersister.NotFoundException {
        Notice notice = noticeRepository.findById(nId)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        notice.setVisible(!notice.isVisible());
        noticeRepository.save(notice);
    }
}
