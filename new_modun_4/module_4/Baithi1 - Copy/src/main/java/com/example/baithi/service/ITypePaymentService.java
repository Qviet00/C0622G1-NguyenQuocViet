package com.example.baithi.service;

import com.example.baithi.model.TypePayment;

import java.util.List;

public interface ITypePaymentService {
    List<TypePayment> findAll();
    TypePayment  findById(int id);

}
