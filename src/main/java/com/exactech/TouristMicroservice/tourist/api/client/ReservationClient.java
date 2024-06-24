package com.exactech.TouristMicroservice.tourist.api.client;

import com.exactech.TouristMicroservice.tourist.mapping.dto.ReservationDto;

import java.util.List;

public interface ReservationClient {
    List<ReservationDto> findReservationsByTouristId(Long touristId);
}
