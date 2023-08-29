package com.example.haemo.haemo.Controller.Acceptation;

import com.example.haemo.haemo.Controller.User.UserController;
import com.example.haemo.haemo.Data.Acceptation.Acceptation;
import com.example.haemo.haemo.Data.Notice.Notice;
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

    @GetMapping("/accept/{uId}")
    @ResponseBody
    public ResponseEntity<Acceptation> acceptUser(@PathVariable Long uId) {
        Acceptation requestedAcceptation = acceptationService.acceptUserToJoin(uId);
        return new ResponseEntity<>(requestedAcceptation, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Acceptation> getAllRequest() {
        return acceptationRepository.findAll();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Acceptation getAcceptationById(@PathVariable Long id) {
        return acceptationRepository.findByuId(id);
    }
}
