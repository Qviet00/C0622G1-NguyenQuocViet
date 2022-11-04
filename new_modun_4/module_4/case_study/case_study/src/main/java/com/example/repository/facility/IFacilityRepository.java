package com.example.repository.facility;

import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(
            value = "select * from furama.facility where facelity_name like %:nameSearch% " +
                    "and facility_type_id like %:facility_type_id% ",
            nativeQuery = true)
    Page<Customer> findAllByNameAndAdress(@Param("nameSearch") String nameSearch,
                                          @Param("facility_type_id")String facelity_type_id, Pageable pageable);
}
