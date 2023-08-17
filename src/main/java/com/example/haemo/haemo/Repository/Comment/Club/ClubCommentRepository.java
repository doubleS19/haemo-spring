package com.example.haemo.haemo.Repository.Comment.Club;

import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubCommentRepository extends JpaRepository<ClubComment, Long> {
    List<ClubComment> findAllByCpId(Long pId);
}