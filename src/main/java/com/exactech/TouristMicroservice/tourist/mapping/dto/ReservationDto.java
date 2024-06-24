package com.exactech.TouristMicroservice.tourist.mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private int tripId;
    private int touristId;
    private Date reservationDate;
    private Date startDate;
    private String status;
}
