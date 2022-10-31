package com.example.service.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> finAll();
    void update(Facility facility);
    void add(Facility facility);
    Optional<Facility> findId(int id);
    Page<Facility> findAllByFacilityName(String name, Pageable pageable);
    void delete(int id);
}
