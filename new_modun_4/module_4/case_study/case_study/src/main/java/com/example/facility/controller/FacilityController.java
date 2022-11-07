package com.example.facility.controller;

import com.example.dtoCustomerAndFacility.FacilityDto;
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
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/listFacility")
    public String searchFacility(@RequestParam(defaultValue = "") String name, String facilityType, Model model,
                                 @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("facility", facilityService.findAllFacility(name, facilityType, pageable));
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/list";
    }


    @GetMapping("/facilityAdd")
    public String facilityAdd(Model model) {
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilityTypeNew", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/facilitySave")
    public String facilitySave(@ModelAttribute("facility") @Validated FacilityDto facilityDto,
                               BindingResult bindingResult, Model model) {
        facilityDto.validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facility", new FacilityDto());
            model.addAttribute("facilityTypeNew", facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        FacilityType facilityType = new FacilityType();
        facilityType.setFacilityTypeId(facilityDto.getFacilityType().getFacilityTypeId());
        facility.setFacilityType(facilityType);

        RentType rentType = new RentType();
        rentType.setRentTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setRentType(rentType);

        facilityService.add(facility);
        return "redirect:/listFacility";

    }

    @GetMapping("/deleteFacility")
    public String deleteFacility(@RequestParam int deleteId) {
        Facility facility = facilityService.findById(deleteId).get();
        facility.setStatus(1);
        facilityService.save(facility);
        return "redirect:/listFacility";
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
