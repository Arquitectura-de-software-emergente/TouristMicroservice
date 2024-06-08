package com.exactech.TouristMicroservice.tourist.controller;

import com.exactech.TouristMicroservice.tourist.http.TouristResponse;
import com.exactech.TouristMicroservice.tourist.model.Tourist;
import com.exactech.TouristMicroservice.tourist.repository.TouristRepository;
import com.exactech.TouristMicroservice.tourist.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tourists")
public class TouristController {
    @Autowired
    private TouristService touristService;
    private final TouristRepository touristRepository;

    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    //Endpoint to get all tourists
    @GetMapping
    public List<Tourist> getAllTourists(){
        return touristService.getAllTourists();
    }

    //Endpoint to create a tourist
    @PostMapping
    public Tourist createTourist(@RequestBody Tourist tourist){
        return touristService.createTourist(tourist);
    }

    //Endpoint to update a tourist
    @PutMapping("/{id}")
    public Tourist updateTourist(@PathVariable Long id, @RequestBody Tourist tourist){
        return touristService.updateTourist(tourist, id);
    }

    //Endpoint to delete a tourist
    @DeleteMapping("/{id}")
    public void deleteTourist(@PathVariable Long id){
        touristService.deleteTourist(id);
    }

    //Endpoint to get tourist by id
    @GetMapping("/{id}")
    public Tourist getTouristById(@PathVariable Long id){
        return touristService.getTouristById(id);
    }

    // Endpoint to get ratings by tourist id
    @GetMapping("/ratings/{touristId}")
    public ResponseEntity<TouristResponse> getRatingsByTouristId(@PathVariable Long touristId) {
        return ResponseEntity.ok(touristService.getRatingsByTouristId(touristId));
    }
}
