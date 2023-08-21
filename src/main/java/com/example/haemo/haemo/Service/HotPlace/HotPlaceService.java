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

//    public List<Post> getPostsAfterDate(String date) {
//        return postRepository.findByDateAfter(date);
//    }

//    public List<PostDto> allCashBoardEntity(){
//        return exec();
//    }
//
//    public List<PostDto> exec(){
//        List<Post> postList = new ArrayList<>(postRepository.findAll());
//
//        List<PostDto> postDtoList = new ArrayList<>();
//
//        for(Post post: postList){
//            PostDto requestDetailAll = new PostDto();
//            requestDetailAll.setPId(post.getPId());
//            requestDetailAll.setTitle(post.getTitle());
//            requestDetailAll.setContent(post.getContent());
//            requestDetailAll.setCategory(post.getCategory());
//            requestDetailAll.setPerson(post.getPerson());
//            requestDetailAll.setNickname(post.getNickname());
//            requestDetailAll.setCreatedAt(post.getCreatedAt());
//            requestDetailAll.setType(post.getType());
//            postDtoList.add(requestDetailAll);
//        }
//        return postDtoList;
//    }
}
