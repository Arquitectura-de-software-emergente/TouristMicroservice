package com.exactech.TouristMicroservice.tourist.api.rest;

import com.exactech.TouristMicroservice.tourist.mapping.dto.LoginDto;
import com.exactech.TouristMicroservice.tourist.resource.LoginResponse;
import com.exactech.TouristMicroservice.tourist.resource.TouristRatingResponse;
import com.exactech.TouristMicroservice.tourist.resource.TouristReservationResponse;
import com.exactech.TouristMicroservice.tourist.domain.model.Tourist;
import com.exactech.TouristMicroservice.tourist.domain.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tourists")
public class TouristController {
    @Autowired
    private TouristService touristService;

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


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = touristService.authenticate(loginDto.email, loginDto.password);
        if (loginResponse.isSuccess()) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }


    //Endpoint to get tourist by id
    @GetMapping("/{id}")
    public Tourist getTouristById(@PathVariable Long id){
        return touristService.getTouristById(id);
    }

    // Endpoint to get ratings by tourist id
    @GetMapping("/ratings/{touristId}")
    public ResponseEntity<TouristRatingResponse> getRatingsByTouristId(@PathVariable Long touristId) {
        return ResponseEntity.ok(touristService.getRatingsByTouristId(touristId));
    }

    // Endpoint to get all tourist ratings
    @GetMapping("/ratings")
    public ResponseEntity<List<TouristRatingResponse>> getAllTouristRatings() {
        return ResponseEntity.ok(touristService.getAllTouristRatings());
    }

    // Endpoint to get reservations by tourist id
    @GetMapping("/reservations/{touristId}")
    public ResponseEntity<TouristReservationResponse> getReservationsByTouristId(@PathVariable Long touristId) {
        return ResponseEntity.ok(touristService.getReservationsByTouristId(touristId));
    }
}
