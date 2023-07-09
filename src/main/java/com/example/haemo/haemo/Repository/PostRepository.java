package com.example.haemo.haemo.Repository;

import com.example.haemo.haemo.Data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByDateContaining(String date);
} 