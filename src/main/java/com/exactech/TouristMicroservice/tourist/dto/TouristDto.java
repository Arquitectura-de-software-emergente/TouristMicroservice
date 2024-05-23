package com.exactech.TouristMicroservice.tourist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TouristDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
