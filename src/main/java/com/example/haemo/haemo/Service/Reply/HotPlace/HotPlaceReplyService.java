package com.example.haemo.haemo.Service.Reply.HotPlace;

import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Reply.HotPlace.HotPlaceReply;
import com.example.haemo.haemo.Repository.Comment.HotPlace.HotPlaceCommentRepository;
import com.example.haemo.haemo.Repository.Reply.HotPlace.HotPlaceReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotPlaceReplyService {

    @Autowired
    HotPlaceReplyRepository commentRepository;

    public HotPlaceReplyService(HotPlaceReplyRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public HotPlaceReply saveComment(HotPlaceReply comment) {
        return commentRepository.save(comment);
    }
}
