package com.example.haemo.haemo.Service;

import com.example.haemo.haemo.Controller.PostController;
import com.example.haemo.haemo.Data.Post;
import com.example.haemo.haemo.Data.PostDto;
import com.example.haemo.haemo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;가
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostController postController;


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

//    public List<Post> getPostsAfterDate(String date) {
//        return postRepository.findByDateAfter(date);
//    }

//    public List<PostDto> allCashBoardEntity(){
//        return exec();
//    }
//
//    public List<PostDto> exec(){
//        List<Post> postList = new ArrayList<>(postRepository.findAll());
//
//        List<PostDto> postDtoList = new ArrayList<>();
//
//        for(Post post: postList){
//            PostDto requestDetailAll = new PostDto();
//            requestDetailAll.setPId(post.getPId());
//            requestDetailAll.setTitle(post.getTitle());
//            requestDetailAll.setContent(post.getContent());
//            requestDetailAll.setCategory(post.getCategory());
//            requestDetailAll.setPerson(post.getPerson());
//            requestDetailAll.setNickname(post.getNickname());
//            requestDetailAll.setCreatedAt(post.getCreatedAt());
//            requestDetailAll.setType(post.getType());
//            postDtoList.add(requestDetailAll);
//        }
//        return postDtoList;
//    }
}
