package com.example.haemo.haemo.Controller.WishList;

import com.example.haemo.haemo.Controller.HotPlace.HotPlaceController;
import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.HotPlace.HotPlaceDto;
import com.example.haemo.haemo.Data.Post.Post;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.HotPlace.HotPlaceRepository;
import com.example.haemo.haemo.Repository.WishList.WishListRepository;
import com.example.haemo.haemo.Service.HotPlace.HotPlaceService;
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

    @Autowired
    private HotPlaceService hotPlaceService;

    @Autowired HotPlaceRepository hotPlaceRepository;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<WishList> getAllWishList() {
        return wishListRepository.findAll();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<WishList> addWishList(@RequestBody WishList wishList) {
        WishList savedWish = wishListService.addWish(wishList);
        HotPlace wishedPlace = hotPlaceService.getHotPlaceById(savedWish.getHpId());
        wishedPlace.setWishing(wishedPlace.getWishing()+1);
        hotPlaceRepository.save(wishedPlace);
        return new ResponseEntity<>(savedWish, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete", produces = "application/json")
    public ResponseEntity<String> deleteWishList(@RequestBody WishList wishList) {
        wishListService.deleteWish(wishList.getUId(), wishList.getHpId());
        HotPlace deletedPlace = hotPlaceService.getHotPlaceById(wishList.getHpId());
        deletedPlace.setWishing(deletedPlace.getWishing()-1);
        hotPlaceRepository.save(deletedPlace);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/myList/{uId}")
    public ResponseEntity<List<HotPlace>> getUserWishList(@PathVariable Long uId) {
        List<HotPlace> wishList = wishListService.getUserWishList(uId);

        return ResponseEntity.ok(wishList);
    }

//    @GetMapping("myList/{uId}")
//    @ResponseBody
//    public List<WishList> getWishListByUId(@PathVariable Long uId) {
//        return wishListRepository.findAllByUId(uId);
//    }
}