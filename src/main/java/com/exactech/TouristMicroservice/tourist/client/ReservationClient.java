package com.exactech.TouristMicroservice.tourist.client;

import com.exactech.TouristMicroservice.tourist.dto.ReservationDto;

import java.util.List;

public interface ReservationClient {
    List<ReservationDto> findReservationsByTouristId(Long touristId);
}
