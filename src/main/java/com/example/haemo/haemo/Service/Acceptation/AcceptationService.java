package com.example.haemo.haemo.Service.Acceptation;

import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import com.example.haemo.haemo.Data.WishList.WishList;
import com.example.haemo.haemo.Repository.Acceptation.AcceptationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptationService {

    @Autowired
    AcceptationRepository acceptationRepository;

    public Acceptation requestAcceptation(Acceptation acceptation) {
        return acceptationRepository.save(acceptation);
    }

    public Acceptation acceptUserToJoin(Long uId){
        Acceptation acceptedJoin = acceptationRepository.findByuId(uId);
        acceptedJoin.setAccept(!acceptedJoin.isAccept());
        acceptationRepository.save(acceptedJoin);
        return acceptedJoin;
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
}
