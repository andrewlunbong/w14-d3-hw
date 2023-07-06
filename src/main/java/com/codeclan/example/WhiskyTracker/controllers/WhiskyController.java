package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies()
    {
        return new ResponseEntity<>( whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{year}")
    public ResponseEntity<List<Whisky>> getAllWhiskyByYear(@PathVariable int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/find")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(
            @RequestParam(name = "byDistillery", required = false) String distillery,
            @RequestParam(name = "byAge", required = false) int age){
//        if((distillery != null) && (Optional.ofNullable(age))
            return new ResponseEntity<>(whiskyRepository.findByDistilleryAndAge(distillery, age), HttpStatus.OK);
    }

//    @GetMapping(value = "/w")
//    public ResponseEntity<List<Ship>> getShipsWithPiratesFirstName(
//            @RequestParam(name = "byPirateFirstName", required = false) String name) {
//        if (name != null) {
//            return new ResponseEntity<>(shipRepository.findByPirates_FirstName(name), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(shipRepository.findAll(), HttpStatus.OK);
//        }
//    }



}
