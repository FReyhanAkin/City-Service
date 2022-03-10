package com.project.CityService.controller;


import com.project.CityService.model.City;
import com.project.CityService.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getCities(){
        return new ResponseEntity<>(cityService.getCity(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City newCity){
        return  new ResponseEntity<>(cityService.createCity(newCity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putCity(@PathVariable String id,@RequestBody City newCity){
        cityService.updateCity(id, newCity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id){
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id){
        return new ResponseEntity<>(cityService.getCityById(id),HttpStatus.OK);
    }
}
