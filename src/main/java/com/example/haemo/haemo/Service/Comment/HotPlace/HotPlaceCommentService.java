package com.example.haemo.haemo.Service.Comment.HotPlace;

import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Comment.HotPlace.HotPlaceCommentRepository;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import com.example.haemo.haemo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotPlaceCommentService {

    @Autowired
    HotPlaceCommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    public HotPlaceCommentService(HotPlaceCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public HotPlaceComment saveComment(HotPlaceComment comment) {
        return commentRepository.save(comment);
    }

    public List<User> getCommentUserList(Long pId) {
        List<HotPlaceComment> comments = commentRepository.findAllByHpId(pId);
        List<User> userList = new ArrayList<>();
        for (HotPlaceComment comment : comments) {
            String nickname = comment.getNickname();
            userList.add(userRepository.findByNickname(nickname));
        }
        return userList;
    }
}
