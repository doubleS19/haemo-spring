package com.example.haemo.haemo.Service.Comment.Club;

import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Repository.Comment.Club.ClubCommentRepository;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubCommentService {

    @Autowired
    ClubCommentRepository commentRepository;

    public ClubCommentService(ClubCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ClubComment saveComment(ClubComment comment) {
        return commentRepository.save(comment);
    }
}
