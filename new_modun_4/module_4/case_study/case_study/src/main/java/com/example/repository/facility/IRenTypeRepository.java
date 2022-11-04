package com.example.repository.facility;

import com.example.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRenTypeRepository extends JpaRepository<RentType, Integer> {
}
