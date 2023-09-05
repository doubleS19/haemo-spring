package com.example.haemo.haemo.Repository.ClubPost;

import com.example.haemo.haemo.Data.ClubPost.ClubPost;
import com.example.haemo.haemo.Data.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubPostRepository extends JpaRepository<ClubPost, Long> {
    List<ClubPost> findBycpIdIn(List<Long> pIds);
}