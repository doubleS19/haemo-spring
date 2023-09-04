package com.example.haemo.haemo.Repository.Post;

import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findBypIdIn(List<Long> pIds);
}