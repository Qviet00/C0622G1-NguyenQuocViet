package com.example.baithi.service.impl;

import com.example.baithi.model.TypePayment;
import com.example.baithi.repository.TypePaymentRepository;
import com.example.baithi.service.ITypePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypePaymentService implements ITypePaymentService {

    @Autowired
    TypePaymentRepository typePaymentRepository;
    @Override
    public List<TypePayment> findAll() {
        return typePaymentRepository.findAll();
    }

    @Override
    public TypePayment findById(int id) {
        return typePaymentRepository.findById(id).orElse(null);
    }
}
