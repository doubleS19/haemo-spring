package com.example.haemo.haemo.Repository.Notice;

import com.example.haemo.haemo.Data.Notice.Notice;
import com.example.haemo.haemo.Data.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> { }