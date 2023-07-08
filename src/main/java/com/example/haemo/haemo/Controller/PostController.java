package com.example.haemo.haemo.Controller;

import com.example.haemo.haemo.Data.Post;
import com.example.haemo.haemo.Data.PostDto;
import com.example.haemo.haemo.Data.User;
import com.example.haemo.haemo.Repository.PostRepository;
import com.example.haemo.haemo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("postUser/{id}")
    @ResponseBody
    public User getUserByPost(@PathVariable Long id){
        Post post = getPostById(id).getBody();
        assert post != null;
        String userNick = post.getNickname();

        User user = userController.getUserByNickname(userNick);
        return user;
    }

    @GetMapping("/24hours")
    public List<PostDto> get24HoursPosts() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime twentyFourHoursAgo = currentDateTime.minusHours(24);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH시");
        String formattedTwentyFourHoursAgo = twentyFourHoursAgo.format(formatter);

        List<Post> posts = postService.getPostsAfterDate(formattedTwentyFourHoursAgo);

        List<PostDto> postResponses = new ArrayList<>();
        for (Post post : posts) {
            PostDto postResponse = new PostDto();
            postResponse.setPId(post.getPId());
            postResponse.setNickname(post.getNickname());
            postResponse.setTitle(post.getTitle());
            postResponse.setContent(post.getContent());
            postResponse.setPerson(post.getPerson());
            postResponse.setCategory(post.getCategory());
            postResponse.setDate(post.getDate());
            postResponse.setType(post.getType());

            postResponses.add(postResponse);
        }
        return postResponses;
    }


//    @GetMapping("/filtered-posts")
//    public List<Post> getFilteredPosts() {
//        Date currentDate = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR, 1);
//        Date tomorrowDate = calendar.getTime();
//
//        List<Post> allPosts = postRepository.findAll();
//        List<Post> filteredPosts = filterPostsByDate(allPosts, currentDate, tomorrowDate);
//
//        return filteredPosts;
//    }
//
//    private List<Post> filterPostsByDate(List<Post> posts, Date currentDate, Date tomorrowDate) {
//        List<Post> filteredPosts = new ArrayList<>();
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시");
//
//        for (Post post : posts) {
//            String postDateString = post.getDate(); // 게시물의 날짜를 문자열로 가져옴
//            try {
//                Date postDate = dateFormat.parse(postDateString);
//
//                if (postDate.after(currentDate) && postDate.before(tomorrowDate)) {
//                    filteredPosts.add(post);
//                }
//            } catch (Exception e) {
//                // 예외 처리
//            }
//        }
//
//        return filteredPosts;
//    }

//    @PostMapping
//    @ResponseBody
//    public ResponseEntity<Post> getPostById(@RequestBody PostDto postDto) {
//        Post post = new Post();
//            Optional<Post> postOptional = postRepository.findById(postDto.getPId());
//            return postOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//
//    }
}
