package com.exactech.TouristMicroservice.tourist.http;

import com.exactech.TouristMicroservice.tourist.dto.ReservationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TouristReservationResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<ReservationDto> reservationsDtoList;
}
