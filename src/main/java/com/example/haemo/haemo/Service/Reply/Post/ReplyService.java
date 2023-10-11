package com.example.haemo.haemo.Service.Reply.Post;

import com.example.haemo.haemo.Data.Reply.Post.Reply;
import com.example.haemo.haemo.Repository.Reply.Post.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    ReplyRepository commentRepository;

    public ReplyService(ReplyRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Reply saveComment(Reply reply) {
        return commentRepository.save(reply);
    }
}
