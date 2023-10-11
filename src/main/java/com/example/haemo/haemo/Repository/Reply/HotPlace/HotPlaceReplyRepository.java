package com.example.haemo.haemo.Repository.Reply.HotPlace;

import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Reply.HotPlace.HotPlaceReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotPlaceReplyRepository extends JpaRepository<HotPlaceReply, Long> {
    List<HotPlaceReply> findAllByHcId(Long hcId);
}