package com.example.haemo.haemo.Repository.Comment.HotPlace;

import com.example.haemo.haemo.Data.Comment.HotPlace.HotPlaceComment;
import com.example.haemo.haemo.Data.Comment.Post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotPlaceCommentRepository extends JpaRepository<HotPlaceComment, Long> {
    List<HotPlaceComment> findAllBypId(Long pId);
}