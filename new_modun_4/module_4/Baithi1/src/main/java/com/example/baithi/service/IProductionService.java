package com.example.baithi.service;

import com.example.baithi.dto.ProductionDto;
import com.example.baithi.model.Production;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductionService {
    Page<ProductionDto> showListConTract(Pageable pageable);

    Production findById(int id);

    void add (Production production);
}
