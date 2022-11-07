package com.example.facility.repository;

import com.example.facility.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(
            value = "select * from furama.facility where facility_name like %:nameSearch% " +
                    "and facility_type_id like %:facility_type_id% and status = 0 ",
            nativeQuery = true)
    Page<Facility> findAllFacility(@Param("nameSearch") String nameSearch,
                                   @Param("facility_type_id") String facility_type_id,
                                   Pageable pageable);
}
