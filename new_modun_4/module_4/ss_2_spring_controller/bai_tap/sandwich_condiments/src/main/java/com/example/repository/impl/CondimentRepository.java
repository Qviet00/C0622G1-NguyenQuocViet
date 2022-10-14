package com.example.repository.impl;

import com.example.model.Condiment;
import com.example.repository.ICondimentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentRepository implements ICondimentRepository {
    private static List<Condiment> condimentList = new ArrayList<>();

    static {
        condimentList.add(new Condiment("Rau diếp cá"));
        condimentList.add(new Condiment("Cà chua"));
        condimentList.add(new Condiment("Mù tạc"));
        condimentList.add(new Condiment("Dưa chua"));
    }

    @Override
    public List<Condiment> findAll() {
        return condimentList;
    }
}