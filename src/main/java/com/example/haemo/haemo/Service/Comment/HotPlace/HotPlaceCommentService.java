package com.example.haemo.haemo.Service.Comment.HotPlace;

import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Repository.Comment.HotPlace.HotPlaceCommentRepository;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotPlaceCommentService {

    @Autowired
    HotPlaceCommentRepository commentRepository;

    public HotPlaceCommentService(HotPlaceCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public HotPlaceComment saveComment(HotPlaceComment comment) {
        return commentRepository.save(comment);
    }
}
