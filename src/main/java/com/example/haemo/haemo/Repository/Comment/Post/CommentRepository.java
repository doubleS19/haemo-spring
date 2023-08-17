package com.example.haemo.haemo.Repository.Comment.Post;

import com.example.haemo.haemo.Data.Comment.Post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllBypId(Long pId);
}