package com.example.repository;

import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderBookRepository extends JpaRepository<Order, Integer> {
}
