package com.exactech.TouristMicroservice.tourist.service;

import com.exactech.TouristMicroservice.tourist.http.TouristRatingResponse;
import com.exactech.TouristMicroservice.tourist.http.TouristReservationResponse;
import com.exactech.TouristMicroservice.tourist.model.Tourist;

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

    //connect to reservation service
    TouristReservationResponse getReservationsByTouristId(Long touristId);
}
