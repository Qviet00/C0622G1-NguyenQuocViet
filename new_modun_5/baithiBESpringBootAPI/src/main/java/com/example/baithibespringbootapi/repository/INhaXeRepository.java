package com.example.baithibespringbootapi.repository;

import com.example.baithibespringbootapi.model.NhaXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhaXeRepository extends JpaRepository<NhaXe, Integer> {
}
