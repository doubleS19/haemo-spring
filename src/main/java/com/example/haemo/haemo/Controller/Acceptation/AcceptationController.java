package com.example.haemo.haemo.Controller.Acceptation;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import com.example.haemo.haemo.Repository.Acceptation.AcceptationRepository;
import com.example.haemo.haemo.Service.Acceptation.AcceptationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/accept/{uId}")
    @ResponseBody
    public ResponseEntity<Acceptation> acceptUser(@PathVariable Long uId) {
        Acceptation requestedAcceptation = acceptationService.acceptUserToJoin(uId);
        return new ResponseEntity<>(requestedAcceptation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Acceptation> getAcceptationById(@PathVariable Long id) {
        Optional<Acceptation> noticeOptional = acceptationRepository.findById(id);
        return noticeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
