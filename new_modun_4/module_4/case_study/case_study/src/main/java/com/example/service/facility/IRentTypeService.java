package com.example.service.facility;


import com.example.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRentTypeService {
    List<RentType> findAll();

}
