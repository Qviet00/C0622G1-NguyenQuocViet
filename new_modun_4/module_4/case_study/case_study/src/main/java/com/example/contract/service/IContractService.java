package com.example.contract.service;

import com.example.contract.model.Contract;
import com.example.dto.ContractPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractPage> showListConTract(Pageable pageable);

    Contract findById(int id);

    void add (Contract contract);
}
