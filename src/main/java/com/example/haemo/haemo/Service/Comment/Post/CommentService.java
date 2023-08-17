package com.example.haemo.haemo.Service.Comment.Post;

import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
