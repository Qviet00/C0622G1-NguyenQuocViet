package com.example.contract.controller;


import com.example.contract.model.AttachFacility;
import com.example.contract.model.Contract;
import com.example.contract.model.ContractDetail;
import com.example.contract.service.IAttachFacilityService;
import com.example.contract.service.IContractDetailService;
import com.example.contract.service.IContractService;
import com.example.customer.service.ICustomerService;
import com.example.dto.ContractPage;
import com.example.employee.service.IEmployeeService;
import com.example.facility.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IContractDetailService contractDetailService;


    @GetMapping("/listContract")
    public String listContract(Model model, @PageableDefault(size = 5) Pageable pageable) {

        model.addAttribute("newContract", new Contract());
        model.addAttribute("contract", contractService.showListConTract(pageable));
        model.addAttribute("listAttachFacility", attachFacilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.finndAll());

        return "contract/list";
    }

    @PostMapping("/saveContract")
    public String saveContract (@ModelAttribute Contract contract) {
        contractService.add(contract);
        return "redirect:/listContract";
    }

    @PostMapping("/saveContractDetail")
    public String addContractDetail(int idContract, int attachFacilityId, int quantity) {
        AttachFacility attachFacility = this.attachFacilityService.findById(attachFacilityId);
        Contract contract = this.contractService.findById(idContract);
        if (contract != null && attachFacility != null) {
            ContractDetail contractDetail = new ContractDetail(quantity, contract, attachFacility);
            contractDetailService.addContractDetail(contractDetail);
        }
        return "redirect:/listContract";
    }


}
