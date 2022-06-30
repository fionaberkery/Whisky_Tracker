package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
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
    public ResponseEntity<List<Whisky>> getAllWhisky(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> findWhiskiesForAParticularYear(
            @RequestParam(name = "year") int year)
    {
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distillery/age")
    public ResponseEntity<List<Whisky>> findWhiskiesFromAParticularDistilleryAndByAge(
            @RequestParam(name = "distillery") String name,
            @RequestParam(name = "age") int age)
    {
        return new ResponseEntity<>(whiskyRepository.findByDistillery_NameAndAge(name, age), HttpStatus.OK);
    }
    // http://localhost:8080/whiskies/distillery/age?distillery=Talisker&age=1 this is how to join two params in url

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> findAllWhiskyFromAParticularRegion(
            @RequestParam(name = "region") String region)
    {
        return new ResponseEntity<>(whiskyRepository.findByDistillery_Region(region), HttpStatus.OK);
    }

}
