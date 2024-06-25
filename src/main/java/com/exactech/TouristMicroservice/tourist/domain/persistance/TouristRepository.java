package com.exactech.TouristMicroservice.tourist.domain.persistance;

import com.exactech.TouristMicroservice.tourist.domain.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Optional<Tourist> findByEmail(String email);
}
