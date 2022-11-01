package com.example.demo.repository;

import com.example.demo.modell.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer > {
}
