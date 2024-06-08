package com.exactech.TouristMicroservice.tourist.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private int score;
    private Date creationDate;
    private int touristId;
    private int tripId;
}