package com.example.haemo.haemo.Service.Comment.Post;

import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.Comment.Post.CommentRepository;
import com.example.haemo.haemo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<User> getCommentUserList(Long pId) {
        List<Comment> comments = commentRepository.findAllBypId(pId);
        List<User> userList = new ArrayList<>();
        for (Comment comment : comments) {
            String nickname = comment.getNickname();
            userList.add(userRepository.findByNickname(nickname));
        }
        return userList;
    }
}
