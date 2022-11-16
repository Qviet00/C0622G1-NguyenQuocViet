package com.example.baithi.service.impl;

import com.example.baithi.dto.ProductionDto;
import com.example.baithi.model.Production;
import com.example.baithi.repository.ProductionRepository;
import com.example.baithi.service.IProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;


@Service
public class ProductionService implements IProductionService {
    @Autowired
    ProductionRepository productionRepository;


    @Override
    public Page<ProductionDto> showListConTract(Pageable pageable) {
        return productionRepository.showListProduction(pageable);
    }

    @Override
    public Production findById(int id) {
        return productionRepository.findById(id).get();
    }

    @Override
    public void add(Production production) {
        productionRepository.save(production);

    }
}
