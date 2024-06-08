package com.exactech.TouristMicroservice.tourist.service;

import com.exactech.TouristMicroservice.tourist.http.TouristResponse;
import com.exactech.TouristMicroservice.tourist.model.Tourist;

import java.util.List;

public interface TouristService {
    Tourist createTourist(Tourist tourist);
    Tourist getTouristById(Long id);
    List<Tourist> getAllTourists();
    Tourist updateTourist(Tourist tourist, Long id);
    void deleteTourist(Long id);

    //connect to rating service
    TouristResponse getRatingsByTouristId(Long touristId);
    List<TouristResponse> getAllTouristRatings();
}
