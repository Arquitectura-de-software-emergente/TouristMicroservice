package com.exactech.TouristMicroservice.tourist.repository;

import com.exactech.TouristMicroservice.tourist.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
