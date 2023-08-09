package com.example.haemo.haemo.Repository.WishList;

import com.example.haemo.haemo.Data.WishList.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findAllByUId(Long pId);
    void deleteByUIdAndPId(Long uId, Long pId);
}