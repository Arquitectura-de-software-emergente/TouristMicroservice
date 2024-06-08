package com.exactech.TouristMicroservice.tourist.client.implementation;

import com.exactech.TouristMicroservice.tourist.client.ReservationClient;
import com.exactech.TouristMicroservice.tourist.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ReservationClientImpl implements ReservationClient {
    private final WebClient webClient;

    @Autowired
    public ReservationClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8086/api/v1").build();
    }

    @Override
    public List<ReservationDto> findReservationsByTouristId(Long touristId) {
        try {
            return webClient.get()
                    .uri("/reservation/by-tourist/{touristId}", touristId)
                    .retrieve()
                    .bodyToFlux(ReservationDto.class)
                    .collectList()
                    .block();
        } catch (Exception e) {
            return null;
        }
    }

}
