package com.example.haemo.haemo.Controller.WishList;

import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.WishList.WishListRepository;
import com.example.haemo.haemo.Service.WishList.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wish")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private WishListRepository wishListRepository;

    @PostMapping(produces = "application/json")
    public ResponseEntity<WishList> addWishList(@RequestBody WishList wishList) {
        WishList savedWish = wishListService.addWish(wishList);
        return new ResponseEntity<>(savedWish, HttpStatus.CREATED);
    }

    @PostMapping(produces = "application/json")
    public void deleteWishList(@RequestBody Long uId, @RequestBody Long pId) {
        wishListService.deleteWish(uId, pId);
    }

    @GetMapping("myList/{uId}")
    @ResponseBody
    public List<WishList> getWishListByUId(@PathVariable Long uId) {
        return wishListRepository.findAllByuId(uId);
    }
}