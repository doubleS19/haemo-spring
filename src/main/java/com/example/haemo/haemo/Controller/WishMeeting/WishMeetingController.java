package com.example.haemo.haemo.Controller.WishMeeting;

import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.WishMeeting.WishMeeting;
import com.example.haemo.haemo.Repository.Post.PostRepository;
import com.example.haemo.haemo.Repository.WishMeeting.WishMeetingRepository;
import com.example.haemo.haemo.Service.Post.PostService;
import com.example.haemo.haemo.Service.WishMeeting.WishMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishMeeting")
public class WishMeetingController {

    @Autowired
    private WishMeetingService wishMeetingService;

    @Autowired
    private WishMeetingRepository wishMeetingRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<WishMeeting> getAllWishMeetingList() {
        return wishMeetingRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<WishMeeting> addWishMeetingList(@RequestBody WishMeeting wishList) {
        WishMeeting savedWish = wishMeetingService.addWish(wishList);
        Post wishedPost = postService.getPostById(savedWish.getPId());
        wishedPost.setWishCnt(wishedPost.getWishCnt()+1);
        postService.savePost(wishedPost);
        return new ResponseEntity<>(savedWish, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{uId}/{pId}", produces = "application/json")
    public ResponseEntity<String> deleteWishMeetingList(@PathVariable Long uId, @PathVariable Long pId) {
        wishMeetingService.deleteWish(uId, pId);
        Post deletedPlace = postService.getPostById(pId);
        deletedPlace.setWishCnt(deletedPlace.getWishCnt()-1);
        System.out.println("deletedPlace.getWishing() = " + deletedPlace.getWishCnt());
        postRepository.save(deletedPlace);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/myList/{uId}")
    public ResponseEntity<List<Post>> getUserWishMeetingList(@PathVariable Long uId) {
        List<Post> wishList = wishMeetingService.getUserWishMeetingList(uId);

        return ResponseEntity.ok(wishList);
    }

    @GetMapping("/isExist/{uId}/{pId}")
    @ResponseBody
    public Boolean checkWishMeetingExist(@PathVariable Long uId, @PathVariable Long pId) {
        return wishMeetingService.checkWishMeetingExist(uId, pId);
    }



//    @GetMapping("myList/{uId}")
//    @ResponseBody
//    public List<WishList> getWishListByUId(@PathVariable Long uId) {
//        return wishListRepository.findAllByUId(uId);
//    }
}