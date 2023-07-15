package com.example.haemo.haemo.Service;

import com.example.haemo.haemo.Data.ClubPost;
import com.example.haemo.haemo.Repository.ClubPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClubPostService {

    @Autowired
    ClubPostRepository clubPostRepository;

    public ClubPostService(ClubPostRepository clubPostRepository) {
        this.clubPostRepository = clubPostRepository;

    }

    public ClubPost savePost(ClubPost post) {
        return clubPostRepository.save(post);
    }


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
