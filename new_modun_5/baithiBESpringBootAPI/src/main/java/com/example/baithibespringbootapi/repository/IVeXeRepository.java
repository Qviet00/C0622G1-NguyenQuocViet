package com.example.baithibespringbootapi.repository;

import com.example.baithibespringbootapi.model.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IVeXeRepository extends JpaRepository<VeXe, Integer> {

    @Query(value = "select* from ve_xe where trang_thai = true order by ve_xe.id desc", nativeQuery = true)
    List<VeXe> findAll();


    @Query(value = "select* from ve_xe where trang_thai = true and id= :id", nativeQuery = true)
      VeXe findById(@Param("id") int id);


}
