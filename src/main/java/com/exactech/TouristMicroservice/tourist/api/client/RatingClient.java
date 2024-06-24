package com.exactech.TouristMicroservice.tourist.api.client;

import com.exactech.TouristMicroservice.tourist.mapping.dto.RatingDto;

import java.util.List;

public interface RatingClient {
    List<RatingDto> findRatingsByTouristId(Long touristId);
    List<RatingDto> findAllRatings();
}
