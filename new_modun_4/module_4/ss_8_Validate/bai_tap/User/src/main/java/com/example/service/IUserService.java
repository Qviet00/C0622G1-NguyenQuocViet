package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IUserService {
   Page<User> findAll(Pageable pageable);
   void create(User user);


   Object findAll();
}
