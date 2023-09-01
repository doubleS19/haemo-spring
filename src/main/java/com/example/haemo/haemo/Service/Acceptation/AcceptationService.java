package com.example.haemo.haemo.Service.Acceptation;

import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.Acceptation.AcceptationRepository;
import com.example.haemo.haemo.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcceptationService {

    @Autowired
    AcceptationRepository acceptationRepository;

    @Autowired
    UserRepository userRepository;

    public Acceptation requestAcceptation(Acceptation acceptation) {
        return acceptationRepository.save(acceptation);
    }

    public Acceptation acceptUserToJoin(Long uId, Long pId){
        List<Acceptation> joinlist = acceptationRepository.findAllByuId(uId);
        Acceptation acceptedReqeust = new Acceptation();
        for(Acceptation wish : joinlist){
            if (wish.getPId().equals(pId)){
                wish.setAccept(!wish.isAccept());
                acceptationRepository.save(wish);
                acceptedReqeust = wish;
            }
        }
        return acceptedReqeust;
    }

    public void cancleRequest(Long uId, Long pId){
        List<Acceptation> wishList = acceptationRepository.findAllByuId(uId);
        for(Acceptation wish : wishList){
            if (wish.getPId().equals(pId)){
                acceptationRepository.delete(wish);
                break;
            }
        }
    }

    public Acceptation getAcceptationByInfo(Long uId, Long pId){
        List<Acceptation> wishList = acceptationRepository.findAllByuId(uId);
        Acceptation acceptedReqeust = new Acceptation();
        for(Acceptation wish : wishList){
            if (wish.getPId().equals(pId)){
                acceptedReqeust = wish;
            }
        }
        return acceptedReqeust;
    }

    public Boolean checkRequestExist(Long uId, Long pId){
        List<Acceptation> wishList = acceptationRepository.findAllByuId(uId);
        boolean isExist = false;
        for(Acceptation wish : wishList) {
            if (wish.getPId().equals(pId)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public List<User> getAttendUserList(Long pId){
        List<Acceptation> wishList = acceptationRepository.findAllBypId(pId);
        List<User> userList = new ArrayList<>();
        for(Acceptation wish : wishList){
            Long uId = wish.getUId();
            User user = userRepository.findById(uId).get();
            userList.add(user);
        }
        return userList;
    }
}
