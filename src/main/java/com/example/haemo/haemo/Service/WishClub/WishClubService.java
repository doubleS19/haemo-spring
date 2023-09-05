package com.example.haemo.haemo.Service.WishClub;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishClubService {

    @Autowired
    WishClubRepository wishClubRepository;

    @Autowired
    ClubPostRepository postRepository;

    @Autowired
    ClubPostService postService;

    public WishClub addWish(WishClub wish) {
        return wishClubRepository.save(wish);
    }

    public void deleteWish(Long uId, Long cpId){
        List<WishClub> wishList = wishClubRepository.findByuId(uId);
        for(WishClub wish : wishList){
            if (wish.getCpId().equals(cpId)){
                wishClubRepository.delete(wish);
                break;
            }
        }
    }

    public List<ClubPost> getUserWishMeetingList(Long uId) {
        List<WishClub> userWishList = wishClubRepository.findByuId(uId);
        List<Long> pIdList = userWishList.stream().map(WishClub::getCpId).collect(Collectors.toList());
        return postRepository.findBycpIdIn(pIdList);
    }

    public Boolean checkWishClubExist(Long uId, Long cpId){
        List<WishClub> wishList = wishClubRepository.findByuId(uId);
        boolean isExist = false;
        for(WishClub wish : wishList) {
            if (wish.getCpId().equals(cpId)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}