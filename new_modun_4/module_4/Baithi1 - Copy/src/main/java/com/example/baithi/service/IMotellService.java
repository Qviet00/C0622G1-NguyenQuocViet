package com.example.baithi.service;

import com.example.baithi.model.Motell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMotellService {
    Page<Motell> findAll(String name, String idTypePamnet, Pageable pageable);
    List<Motell> findAll();

    void save(Motell motell);

    void delete(int id);

    Optional<Motell> findById (int id);
}
