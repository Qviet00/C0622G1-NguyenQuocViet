package com.example.baithi.repository;

import com.example.baithi.model.Motell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotelRepository extends JpaRepository<Motell, Integer> {
    @Query(
            value = "select * from bai_thi.motell where name like %:nameSearch% " +
                    "and id_type_payment like %:id_type_payment% and status = 0 ",
            nativeQuery = true)
    Page<Motell> findAllFacility(@Param("nameSearch") String nameSearch,
                                   @Param("id_type_payment") String id_type_payment,
                                   Pageable pageable);
}
