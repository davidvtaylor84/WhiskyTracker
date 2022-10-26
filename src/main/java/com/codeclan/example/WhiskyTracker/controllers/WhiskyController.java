package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name="year", required = false) Integer year){
        if(year!=null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleries")
    public ResponseEntity<List<Whisky>> getWhiskiesByDistillery(
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name="region") String region){
        if(age!=null && name!=null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
        } else if(region!=null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value = "/whiskies/distilleries")
//    public ResponseEntity<List<Whisky>> getWhiskiesByDistilleryRegion(
//            @RequestParam(name="region") String region){
//        if(region!=null){
//            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }

//    @GetMapping(value = "/whiskies/distilleries")
//    public ResponseEntity<List<Whisky>> getWhiskiesByDistillery(
//            @RequestParam(name = "age", required = false) Integer age,
//            @RequestParam(name = "name", required = false) String name){
//        if(age!=null && name!=null){
//            return new ResponseEntity<>(whiskyRepository.findWhiskyByAgeAndDistilleryName(age, name), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }






}
