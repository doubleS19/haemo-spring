package com.example.haemo.haemo.Service.Comment.Club;

import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Comment.Club.ClubCommentRepository;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import com.example.haemo.haemo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubCommentService {

    @Autowired
    ClubCommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    public ClubCommentService(ClubCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ClubComment saveComment(ClubComment comment) {
        return commentRepository.save(comment);
    }

    public List<User> getCommentUserList(Long pId) {
        List<ClubComment> comments = commentRepository.findAllByCpId(pId);
        List<User> userList = new ArrayList<>();
        for (ClubComment comment : comments) {
            String nickname = comment.getNickname();
            userList.add(userRepository.findByNickname(nickname));
        }
        return userList;
    }
}
