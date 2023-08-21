package com.example.haemo.haemo.Repository.HotPlace;
import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotPlaceRepository extends JpaRepository<HotPlace, Long> {
    List<HotPlace> findByHpIdIn(List<Long> pIds);
}