package com.exactech.TouristMicroservice.tourist.service;

import com.exactech.TouristMicroservice.shared.exception.ResourceNotFoundException;
import com.exactech.TouristMicroservice.tourist.api.client.RatingClient;
import com.exactech.TouristMicroservice.tourist.api.client.ReservationClient;
import com.exactech.TouristMicroservice.tourist.mapping.dto.RatingDto;
import com.exactech.TouristMicroservice.tourist.mapping.dto.ReservationDto;
import com.exactech.TouristMicroservice.tourist.resource.TouristRatingResponse;
import com.exactech.TouristMicroservice.tourist.resource.TouristReservationResponse;
import com.exactech.TouristMicroservice.tourist.domain.model.Tourist;
import com.exactech.TouristMicroservice.tourist.domain.persistance.TouristRepository;
import com.exactech.TouristMicroservice.tourist.domain.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TouristImpl implements TouristService {
    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    private RatingClient ratingClient;

    @Autowired
    private ReservationClient reservationClient;

    @Override
    public Tourist createTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Override
    public Tourist getTouristById(Long id) {
        Optional<Tourist> touristOptional = touristRepository.findById(id);
        if (touristOptional.isPresent()) {
            return touristOptional.get();
        } else {
            throw new ResourceNotFoundException("Tourist not found with id " + id);
        }
    }

    @Override
    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    @Override
    public Tourist updateTourist(Tourist tourist, Long id) {
        Optional<Tourist> existingTouristOptional = touristRepository.findById(id);
        if (existingTouristOptional.isPresent()) {
            Tourist existingTourist = existingTouristOptional.get();
            // Campos que se pueden actualizar
            existingTourist.setName(tourist.getName());
            existingTourist.setEmail(tourist.getEmail());
            existingTourist.setPhone(tourist.getPhone());
            existingTourist.setAddress(tourist.getAddress());

            return touristRepository.save(existingTourist);
        } else {
            throw new ResourceNotFoundException("Tourist not found with id " + id);
        }
    }

    @Override
    public void deleteTourist(Long id) {
        if (touristRepository.existsById(id)) {
            touristRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Tourist not found with id " + id);
        }
    }

    @Override
    public TouristRatingResponse getRatingsByTouristId(Long touristId) {
        Tourist tourist = touristRepository.findById(touristId).orElse(new Tourist());
        List<RatingDto> ratingsDto = ratingClient.findRatingsByTouristId(touristId);
        return TouristRatingResponse.builder()
                .id(tourist.getId())
                .name(tourist.getName())
                .email(tourist.getEmail())
                .phone(tourist.getPhone())
                .address(tourist.getAddress())
                .ratingsDtoList(ratingsDto)
                .build();
    }

    @Override
    public List<TouristRatingResponse> getAllTouristRatings() {
        List<Tourist> tourists = getAllTourists();
        List<RatingDto> allRatings = ratingClient.findAllRatings();

        return tourists.stream().map(tourist -> {
            List<RatingDto> touristRatings = allRatings.stream()
                    .filter(rating -> rating.getTouristId() == tourist.getId())
                    .collect(Collectors.toList());
            return TouristRatingResponse.builder()
                    .id(tourist.getId())
                    .name(tourist.getName())
                    .email(tourist.getEmail())
                    .phone(tourist.getPhone())
                    .address(tourist.getAddress())
                    .ratingsDtoList(touristRatings)
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public TouristReservationResponse getReservationsByTouristId(Long touristId) {
        Tourist tourist = touristRepository.findById(touristId).orElse(new Tourist());
        List<ReservationDto> reservationDto = reservationClient.findReservationsByTouristId(touristId);
        return TouristReservationResponse.builder()
                .id(tourist.getId())
                .name(tourist.getName())
                .email(tourist.getEmail())
                .phone(tourist.getPhone())
                .address(tourist.getAddress())
                .reservationsDtoList(reservationDto)
                .build();
    }
}
