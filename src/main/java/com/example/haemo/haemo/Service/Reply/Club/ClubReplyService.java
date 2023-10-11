package com.example.haemo.haemo.Service.Reply.Club;

import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Reply.Club.ClubReply;
import com.example.haemo.haemo.Repository.Comment.Club.ClubCommentRepository;
import com.example.haemo.haemo.Repository.Reply.Club.ClubReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubReplyService {

    @Autowired
    ClubReplyRepository commentRepository;

    public ClubReplyService(ClubReplyRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ClubReply saveComment(ClubReply comment) {
        return commentRepository.save(comment);
    }
}
