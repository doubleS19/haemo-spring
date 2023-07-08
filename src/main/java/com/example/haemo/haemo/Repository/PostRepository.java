package com.example.haemo.haemo.Repository;

import com.example.haemo.haemo.Data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByDateAfter(String date);
} 