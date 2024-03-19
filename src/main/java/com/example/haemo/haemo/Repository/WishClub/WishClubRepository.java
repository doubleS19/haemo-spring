package com.example.haemo.haemo.Repository.WishClub;

import com.example.haemo.haemo.Data.WishClub.WishClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishClubRepository extends JpaRepository<WishClub, Long> {
    List<WishClub> findByuId(Long uId);
}