package com.example.haemo.haemo.Repository;

import com.example.haemo.haemo.Data.Comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}