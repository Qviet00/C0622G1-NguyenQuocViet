package com.example.contract.controller;


import com.example.contract.model.AttachFacility;
import com.example.contract.model.Contract;
import com.example.contract.model.ContractDetail;
import com.example.contract.service.IAttachFacilityService;
import com.example.contract.service.IContractDetailService;
import com.example.contract.service.IContractService;
import com.example.customer.service.ICustomerService;

import com.example.dto.ContractDto;
import com.example.employee.service.IEmployeeService;
import com.example.facility.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private ICustomerService customerService;
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IContractDetailService contractDetailService;


    @GetMapping("/listContract")
    public String listContract(Model model, @PageableDefault(size = 5) Pageable pageable){

        model.addAttribute("newContract", new Contract());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contract", contractService.showListConTract(pageable));
        model.addAttribute("listAttachFacility", attachFacilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.finndAll());
        return "contract/list";
    }

    @PostMapping("/saveContract")
    public String saveContract(Model model,@ModelAttribute("contractDto")@Validated ContractDto contractDto, BindingResult bindingResult,@PageableDefault(size = 5) Pageable pageable) {

        contractDto.validate(contractDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
//            model.addAttribute("contractDto",contractDto);
            model.addAttribute("newContract", new Contract());
            model.addAttribute("contract", contractService.showListConTract(pageable));
            model.addAttribute("listAttachFacility", attachFacilityService.findAll());
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("facilityList", facilityService.finndAll());
            return "contract/list";
        }

        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.add(contract);
        return "redirect:/listContract";
    }

    @PostMapping("/saveContractDetail")
    public String addContractDetail(@RequestParam String idContract,
                                    @RequestParam String attachFacilityId,
                                    @RequestParam String quantity) {
        AttachFacility attachFacility = this.attachFacilityService.findById(Integer.parseInt(attachFacilityId));
        Contract contract = this.contractService.findById(Integer.parseInt(idContract));
        if (contract != null && attachFacility != null) {
            ContractDetail contractDetail = new ContractDetail(Integer.parseInt(quantity), contract,attachFacility);
            contractDetailService.addContractDetail(contractDetail);
        }
        return "redirect:/listContract";
    }
}
