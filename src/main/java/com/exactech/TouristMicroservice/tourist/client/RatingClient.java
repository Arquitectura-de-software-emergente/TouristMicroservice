package com.exactech.TouristMicroservice.tourist.client;

import com.exactech.TouristMicroservice.tourist.dto.RatingDto;

import java.util.List;

public interface RatingClient {
    List<RatingDto> findRatingsByTouristId(Long touristId);
}
