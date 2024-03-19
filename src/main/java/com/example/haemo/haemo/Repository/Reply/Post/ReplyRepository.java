package com.example.haemo.haemo.Repository.Reply.Post;

import com.example.haemo.haemo.Data.Comment.Post.Comment;
import com.example.haemo.haemo.Data.Reply.Post.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllBycId(Long cId);
}