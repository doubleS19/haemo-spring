package com.example.haemo.haemo.Controller.Acceptation;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import com.example.haemo.haemo.Data.HotPlace.HotPlace;
import com.example.haemo.haemo.Data.Notice.Notice;
import com.example.haemo.haemo.Data.User.User;
import com.example.haemo.haemo.Repository.Acceptation.AcceptationRepository;
import com.example.haemo.haemo.Service.Acceptation.AcceptationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/accept")
public class AcceptationController {

    @Autowired
    private AcceptationService acceptationService;

    @Autowired
    private AcceptationRepository acceptationRepository;

    @Autowired
    private UserController userController;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Acceptation> requestJoin(@RequestBody Acceptation acceptation) {
        Acceptation requestedAcceptation = acceptationService.requestAcceptation(acceptation);
        return new ResponseEntity<>(requestedAcceptation, HttpStatus.CREATED);
    }

    @GetMapping("/accept/{uId}/{pId}")
    @ResponseBody
    public ResponseEntity<Acceptation> acceptUser(@PathVariable Long uId, @PathVariable Long pId) {
        Acceptation requestedAcceptation = acceptationService.acceptUserToJoin(uId, pId);
        return new ResponseEntity<>(requestedAcceptation, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Acceptation> getAllRequest() {
        return acceptationRepository.findAll();
    }

    @DeleteMapping(value = "/delete/{uId}/{pId}", produces = "application/json")
    public ResponseEntity<String> deleteWishList(@PathVariable Long uId, @PathVariable Long pId) {
        acceptationService.cancleRequest(uId, pId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/check/{uId}/{pId}")
    @ResponseBody
    public Acceptation getAcceptationById(@PathVariable Long uId, @PathVariable Long pId) {
        return acceptationService.getAcceptationByInfo(uId, pId);
    }

    @GetMapping("/isExist/{uId}/{pId}")
    @ResponseBody
    public Boolean checkRequestExist(@PathVariable Long uId, @PathVariable Long pId) {
        return acceptationService.checkRequestExist(uId, pId);
    }

    @GetMapping("/userList/{pId}")
    @ResponseBody
    public List<User> getAttendUserList(@PathVariable Long pId) {
        return acceptationService.getAttendUserList(pId);
    }
}
