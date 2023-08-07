package com.example.haemo.haemo.Service.WishList;

import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.WishList.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public WishList addWish(WishList wish) {
        return wishListRepository.save(wish);
    }

    public void deleteWish(Long uId, Long pId) {
        List<WishList> allWish = wishListRepository.findAllByuId(uId);

        for (WishList wish : allWish) {
            if (wish.getPId().equals(pId)) {
                wishListRepository.deleteById(wish.getWId());
                break;
            }
        }
    }
}