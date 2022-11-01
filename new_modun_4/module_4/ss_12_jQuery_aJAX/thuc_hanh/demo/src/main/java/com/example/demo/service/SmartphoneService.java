package com.example.demo.service;

import com.example.demo.modell.Smartphone;
import com.example.demo.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SmartphoneService implements ISmartphoneService {

    @Autowired
    private ISmartphoneRepository smartphoneRepository;
    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(int id) {
        smartphoneRepository.deleteById(id);
    }
}
