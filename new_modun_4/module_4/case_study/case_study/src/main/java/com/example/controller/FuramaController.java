package com.example.controller;


import com.example.customer.model.Customer;
import com.example.customer.model.TypeCustomer;
import com.example.customer.service.ICustomerService;
import com.example.customer.service.ITypeCustomerService;
import com.example.dto.CustomerDto;
import com.example.dto.FacilityDto;
import com.example.facility.model.Facility;
import com.example.facility.model.FacilityType;
import com.example.facility.model.RentType;
import com.example.facility.service.IFacilityService;
import com.example.facility.service.IFacilityTypeService;
import com.example.facility.service.IRentTypeService;
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

import javax.validation.Valid;


@Controller
public class FuramaController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITypeCustomerService typeCustomerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/listCustomer")
    public String searchTypeAndName(@RequestParam(defaultValue = "") String name, String email, String type, Model model,
                                    @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customer", customerService.findAllByNameAndAdress(name, email, type, pageable));
        model.addAttribute("type", typeCustomerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/listFacility")
    public String searchFacility(@RequestParam(defaultValue = "") String name, String facilityType, Model model,
                                 @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("facility", facilityService.findAllFacility(name, facilityType, pageable));
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/list";
    }

    @GetMapping("/customerAdd")
    public String customerAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("type", typeCustomerService.findAll());
        return "customer/add";
    }
    @GetMapping("/facilityAdd")
    public String Facility(Model model){
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilitiTypeNew",facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/facilitySave")
    public String saveFacility(@ModelAttribute("facility")@Validated FacilityDto facilityDto,
                               BindingResult bindingResult, Model model){
        facilityDto.validate(facilityDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facilityTypeNew", facilityTypeService.findAll());
            model.addAttribute("rentTypeList",rentTypeService.findAll());
            return "facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);

        FacilityType facilityType = new FacilityType();
        facilityType.setFacilityTypeId(facilityDto.getFacilityType().getFacilityTypeId());
        facility.setFacilityType(facilityType);

        RentType rentType =new RentType();
        rentType.setRentTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setRentType(rentType);

        facilityService.add(facility);
        return "redirect:/listFacility";

    }

    @PostMapping("/customerSave")
    public String saveCustomer(@ModelAttribute("customerDto") @Validated CustomerDto customerDto,
                               BindingResult bindingResult, Model model) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("type", typeCustomerService.findAll());
            return "/customer/add";
        }
        Customer customer = new Customer();
        TypeCustomer typeCustomer = typeCustomerService.findById(Integer.parseInt(customerDto.getTypeCustomer()));
        customer.setTypeCustomer(typeCustomer);
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/listCustomer";
    }


    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int deleteId) {
        Customer customer = customerService.findById(deleteId).get();
        customer.setStatus(1);
        customerService.save(customer);
        return "redirect:/listCustomer";
    }

    @GetMapping("/deleteFacility")
    public String deleteFacility(@RequestParam int deleteId) {
        Facility facility = facilityService.findById(deleteId).get();
        facility.setStatus(1);
        facilityService.save(facility);
        return "redirect:/listFacility";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        model.addAttribute("type", typeCustomerService.findAll());
        return "customer/update";
    }

    @PostMapping("/saveUpdateCustomer")
    public String saveUpdateCustomer(@ModelAttribute("customer") @Validated CustomerDto customerDto,
                                     BindingResult bindingResult, Model model) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", typeCustomerService.findAll());
            return "customer/update";
        }
        Customer customer = new Customer();
        TypeCustomer typeCustomer = typeCustomerService.findById(Integer.parseInt(customerDto.getTypeCustomer()));
        customer.setTypeCustomer((typeCustomer));
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/listCustomer";
    }

    @GetMapping("/updateFacility")
    public String updateFacility(@RequestParam int id, Model model) {
        model.addAttribute("facilityList", facilityService.findById(id).get());
        model.addAttribute("facilityTypeNew", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/update";
    }

    @PostMapping("/saveUpdateFacility")
    public String saveUpdateFacility(@ModelAttribute("facility") @Valid FacilityDto facilityDto,
                                     BindingResult bindingResult, Model model) {
        facilityDto.validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {

            model.addAttribute("facilityTypeNew", facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "facility/update";
        }
        Facility facility = new Facility();

        FacilityType facilityType = new FacilityType();
        facilityType.setFacilityTypeId(facilityDto.getFacilityType().getFacilityTypeId());
        facility.setFacilityType(facilityType);

        RentType rentType = new RentType();
        rentType.setRentTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setRentType(rentType);


        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return "redirect:/listFacility";
    }
}
