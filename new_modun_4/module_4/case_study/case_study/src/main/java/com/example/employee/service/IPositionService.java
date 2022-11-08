package com.example.employee.service;

import com.example.employee.model.Position;

import java.util.List;
import java.util.Optional;

public interface IPositionService {

    List<Position> findAll();
    void save(Position position);

    void delete(int id);

    Optional<Position> findById (int id);
}
