package com.example.haemo.haemo.Service.WishList;

import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.HotPlace.HotPlaceDto;
import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.HotPlace.HotPlaceRepository;
import com.example.haemo.haemo.Repository.WishList.WishListRepository;
import com.example.haemo.haemo.Service.HotPlace.HotPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    HotPlaceRepository hotPlaceRepository;

    @Autowired
    HotPlaceService hotPlaceService;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public WishList addWish(WishList wish) {
        HotPlace wishedPlace = hotPlaceService.getHotPlaceById(wish.getHpId());
        wishedPlace.setWishing(wishedPlace.getWishing()+1);
        hotPlaceRepository.save(wishedPlace);
        return wishListRepository.save(wish);
    }

    public void deleteWish(Long uId, Long hpId){
        List<WishList> wishList = wishListRepository.findByUId(uId);
        for(WishList wish : wishList){
            if (wish.getHpId().equals(hpId)){
                wishListRepository.delete(wish);
                HotPlace deletedPlace = hotPlaceService.getHotPlaceById(wish.getHpId());
                deletedPlace.setWishing(deletedPlace.getWishing()-1);
                hotPlaceRepository.save(deletedPlace);
                break;
            }
        }
    }

    public List<HotPlace> getUserWishList(Long uId) {
        List<WishList> userWishList = wishListRepository.findByUId(uId);
        List<Long> pIdList = userWishList.stream().map(WishList::getHpId).collect(Collectors.toList());
        List<HotPlace> hotPlaceList = hotPlaceRepository.findByHpIdIn(pIdList);
        return hotPlaceList;
    }
}