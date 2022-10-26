package com.example.service;

import com.example.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    void save(Order order);

}
