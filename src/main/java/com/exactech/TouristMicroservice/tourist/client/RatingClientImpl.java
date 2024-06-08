package com.exactech.TouristMicroservice.tourist.client;

import com.exactech.TouristMicroservice.tourist.dto.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RatingClientImpl implements RatingClient{

    private final WebClient webClient;

    @Autowired
    public RatingClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/api/v1").build();
    }

    @Override
    public List<RatingDto> findRatingsByTouristId(Long touristId) {
        try{
            return webClient.get()
                    .uri("/ratings/by-tourist/{touristId}", touristId)
                    .retrieve()
                    .bodyToFlux(RatingDto.class)
                    .collectList()
                    .block();
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<RatingDto> findAllRatings() {
        try {
            return webClient.get()
                    .uri("/rating")
                    .retrieve()
                    .bodyToFlux(RatingDto.class)
                    .collectList()
                    .block();
        } catch (Exception e) {
            return null;
        }
    }
}
