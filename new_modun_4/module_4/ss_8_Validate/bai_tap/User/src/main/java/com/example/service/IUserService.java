package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void create(User user);


    Optional<User> findById(int id);
    Page<User> searchByName(String firsName,Pageable pageable);

}
