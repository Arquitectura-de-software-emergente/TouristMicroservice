package com.exactech.TouristMicroservice.tourist.domain.persistance;

import com.exactech.TouristMicroservice.tourist.domain.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
