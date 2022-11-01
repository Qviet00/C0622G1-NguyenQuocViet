package com.example.demo.service;

import com.example.demo.modell.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<Smartphone> findAll();
    Optional<Smartphone> findById(int id);
    Smartphone save(Smartphone smartphone);
    void remove(int id);
}
