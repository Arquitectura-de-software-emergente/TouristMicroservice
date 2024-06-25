package com.exactech.TouristMicroservice.tourist.domain.service;

import com.exactech.TouristMicroservice.tourist.resource.LoginResponse;
import com.exactech.TouristMicroservice.tourist.resource.TouristRatingResponse;
import com.exactech.TouristMicroservice.tourist.resource.TouristReservationResponse;
import com.exactech.TouristMicroservice.tourist.domain.model.Tourist;

import java.util.List;

public interface TouristService {
    Tourist createTourist(Tourist tourist);
    Tourist getTouristById(Long id);
    List<Tourist> getAllTourists();
    Tourist updateTourist(Tourist tourist, Long id);
    void deleteTourist(Long id);

    //connect to rating service
    TouristRatingResponse getRatingsByTouristId(Long touristId);
    List<TouristRatingResponse> getAllTouristRatings();


    LoginResponse authenticate(String email, String password);

    //connect to reservation service
    TouristReservationResponse getReservationsByTouristId(Long touristId);
}
