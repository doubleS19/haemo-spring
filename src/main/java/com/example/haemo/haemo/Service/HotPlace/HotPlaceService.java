package com.example.haemo.haemo.Service.HotPlace;
import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Repository.HotPlace.HotPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotPlaceService {

    @Autowired
    HotPlaceRepository hotPlaceRepository;

    public HotPlaceService(HotPlaceRepository hotPlaceRepository) {
        this.hotPlaceRepository = hotPlaceRepository;

    }

    public HotPlace savePost(HotPlace post) {
        return hotPlaceRepository.save(post);
    }

    public HotPlace getHotPlaceById(Long pId){
        return hotPlaceRepository.getReferenceById(pId);
    }

    public List<HotPlace> getHotPlacesByPIds(List<Long> pIds) {
        return hotPlaceRepository.findByHpIdIn(pIds);
    }

    public void saveHotPlaceImages(Long pId, List<byte[]> imageList) {
        HotPlace hotPlace = hotPlaceRepository.findById(pId).orElse(null);
        if (hotPlace != null) {
            hotPlace.setImageList(imageList);
            hotPlaceRepository.save(hotPlace);
        } else {
            // 해당 pId의 핫플레이스를 찾을 수 없음
            // 오류 처리 또는 예외 처리 추가
        }
    }

    public List<byte[]> getHotPlaceImages(Long pId) {
        HotPlace hotPlace = hotPlaceRepository.findById(pId).orElse(null);
        if (hotPlace != null) {
            return hotPlace.getImageList();
        } else {
            // 해당 pId의 핫플레이스를 찾을 수 없음
            // 오류 처리 또는 예외 처리 추가
            return null; // 또는 다른 적절한 처리
        }
    }
}
