package com.example.haemo.haemo.Service.WishMeeting;

import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Data.WishMeeting.WishMeeting;
import com.example.haemo.haemo.Repository.HotPlace.HotPlaceRepository;
import com.example.haemo.haemo.Repository.Post.PostRepository;
import com.example.haemo.haemo.Repository.WishList.WishListRepository;
import com.example.haemo.haemo.Repository.WishMeeting.WishMeetingRepository;
import com.example.haemo.haemo.Service.HotPlace.HotPlaceService;
import com.example.haemo.haemo.Service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishMeetingService {

    @Autowired
    WishMeetingRepository wishMeetingRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    public WishMeeting addWish(WishMeeting wish) {
        return wishMeetingRepository.save(wish);
    }

    public void deleteWish(Long uId, Long pId){
        List<WishMeeting> wishList = wishMeetingRepository.findByuId(uId);
        for(WishMeeting wish : wishList){
            if (wish.getPId().equals(pId)){
                wishMeetingRepository.delete(wish);
                break;
            }
        }
    }

    public List<Post> getUserWishMeetingList(Long uId) {
        List<WishMeeting> userWishList = wishMeetingRepository.findByuId(uId);
        List<Long> pIdList = userWishList.stream().map(WishMeeting::getPId).collect(Collectors.toList());
        return postRepository.findBypIdIn(pIdList);
    }
}