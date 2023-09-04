package com.example.haemo.haemo.Repository.WishMeeting;

import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Data.WishMeeting.WishMeeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishMeetingRepository extends JpaRepository<WishMeeting, Long> {
    List<WishMeeting> findByuId(Long uId);
}