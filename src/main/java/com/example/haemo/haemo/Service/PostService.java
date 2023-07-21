package com.example.haemo.haemo.Service;

import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPostsAfterTime(LocalDateTime startTime, LocalDateTime endTime) {
        List<Post> allPosts = postRepository.findAll();
        List<Post> postsAfterTime = new ArrayList<>();

        for (Post post : allPosts) {
            LocalDateTime postDate = convertStringToDate(post.getDeadline());
            if (postDate != null && postDate.isAfter(startTime) && postDate.isBefore(endTime)) {
                postsAfterTime.add(post);
            }
        }

        return postsAfterTime;
    }

    private LocalDateTime convertStringToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시");
        try {
            return LocalDateTime.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            // Handle the exception or return null as per your requirement
            return null;
        }
    }

//    private List<Post> getSortedPostByDate(){
//
//    }

}
