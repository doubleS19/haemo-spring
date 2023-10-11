package com.example.haemo.haemo.Repository.Reply.Club;

import com.example.haemo.haemo.Data.Comment.Club.ClubComment;
import com.example.haemo.haemo.Data.Reply.Club.ClubReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubReplyRepository extends JpaRepository<ClubReply, Long> {
    List<ClubReply> findAllByCcId(Long ccId);
}