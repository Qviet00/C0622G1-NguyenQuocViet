package com.example.baithi.service.impl;

import com.example.baithi.model.Motell;
import com.example.baithi.repository.MotelRepository;
import com.example.baithi.service.IMotellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MotellService implements IMotellService {

    @Autowired
    MotelRepository motelRepository;

    @Override
    public Page<Motell> findAll(String name, String idTypePamnet, Pageable pageable) {
        return motelRepository.findAllFacility(name,idTypePamnet,pageable);
    }

    @Override
    public List<Motell> findAll() {
        return motelRepository.findAll();
    }

    @Override
    public void save(Motell motell) {
    motelRepository.save(motell);
    }

    @Override
    public void delete(int id) {
    motelRepository.deleteById(id);
    }

    @Override
    public Optional<Motell> findById(int id) {
        return motelRepository.findById(id);
    }
}
