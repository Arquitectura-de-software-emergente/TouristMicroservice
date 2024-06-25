package com.exactech.TouristMicroservice.tourist.resource;

import com.exactech.TouristMicroservice.tourist.mapping.dto.ReservationDto;
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
    private String phone;
    private String address;
    private String email;
    private String password;
    private List<ReservationDto> reservationsDtoList;
}
