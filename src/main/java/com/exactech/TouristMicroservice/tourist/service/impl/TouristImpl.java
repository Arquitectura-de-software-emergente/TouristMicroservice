package com.exactech.TouristMicroservice.tourist.service.impl;

import com.exactech.TouristMicroservice.shared.exception.ResourceNotFoundException;
import com.exactech.TouristMicroservice.tourist.dto.TouristDto;
import com.exactech.TouristMicroservice.tourist.model.Tourist;
import com.exactech.TouristMicroservice.tourist.repository.TouristRepository;
import com.exactech.TouristMicroservice.tourist.service.TouristService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristImpl implements TouristService {
    @Autowired
    private TouristRepository touristRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TouristImpl(TouristRepository touristRepository, ModelMapper modelMapper) {
        this.touristRepository = touristRepository;
        this.modelMapper = new ModelMapper();
    }
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

    private TouristDto EntityToDto(Tourist tourist){
        return modelMapper.map(tourist, TouristDto.class);
    }
}
