package com.example.haemo.haemo.Controller.WishClub;

import com.example.haemo.haemo.Data.ClubPost.ClubPost;
import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.WishClub.WishClub;
import com.example.haemo.haemo.Data.WishMeeting.WishMeeting;
import com.example.haemo.haemo.Repository.ClubPost.ClubPostRepository;
import com.example.haemo.haemo.Repository.Post.PostRepository;
import com.example.haemo.haemo.Repository.WishClub.WishClubRepository;
import com.example.haemo.haemo.Repository.WishMeeting.WishMeetingRepository;
import com.example.haemo.haemo.Service.ClubPost.ClubPostService;
import com.example.haemo.haemo.Service.Post.PostService;
import com.example.haemo.haemo.Service.WishClub.WishClubService;
import com.example.haemo.haemo.Service.WishMeeting.WishMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishClub")
public class WishClubController {

    @Autowired
    private WishClubService wishClubService;

    @Autowired
    private WishClubRepository wishClubRepository;

    @Autowired
    private ClubPostService postService;

    @Autowired
    private ClubPostRepository postRepository;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<WishClub> getAllWishMeetingList() {
        return wishClubRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<WishClub> addWishMeetingList(@RequestBody WishClub wishList) {
        WishClub savedWish = wishClubService.addWish(wishList);
        ClubPost wishedPost = postService.getClubPostById(savedWish.getCpId());
        wishedPost.setWishClubCnt(wishedPost.getWishClubCnt()+1);
        postService.savePost(wishedPost);
        return new ResponseEntity<>(savedWish, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{uId}/{cpId}", produces = "application/json")
    public ResponseEntity<String> deleteWishClubList(@PathVariable Long uId, @PathVariable Long cpId) {
        wishClubService.deleteWish(uId, cpId);
        ClubPost deletedPlace = postService.getClubPostById(cpId);
        deletedPlace.setWishClubCnt(deletedPlace.getWishClubCnt()-1);
        System.out.println("deletedPlace.getWishing() = " + deletedPlace.getWishClubCnt());
        postRepository.save(deletedPlace);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/myList/{uId}")
    public ResponseEntity<List<ClubPost>> getUserWishClubList(@PathVariable Long uId) {
        List<ClubPost> wishList = wishClubService.getUserWishMeetingList(uId);

        return ResponseEntity.ok(wishList);
    }

    @GetMapping("/isExist/{uId}/{cpId}")
    @ResponseBody
    public Boolean checkWishClubExist(@PathVariable Long uId, @PathVariable Long cpId) {
        return wishClubService.checkWishClubExist(uId, cpId);
    }



//    @GetMapping("myList/{uId}")
//    @ResponseBody
//    public List<WishList> getWishListByUId(@PathVariable Long uId) {
//        return wishListRepository.findAllByUId(uId);
//    }
}