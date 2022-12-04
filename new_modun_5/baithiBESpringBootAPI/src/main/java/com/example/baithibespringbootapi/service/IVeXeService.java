package com.example.baithibespringbootapi.service;

import com.example.baithibespringbootapi.model.VeXe;


import java.util.List;

public interface IVeXeService {

    List<VeXe> findAll();

    void save(VeXe veXe);

    VeXe findById(int id);

    void remove(int id);

    VeXe findByIdOptional(int id);

}
