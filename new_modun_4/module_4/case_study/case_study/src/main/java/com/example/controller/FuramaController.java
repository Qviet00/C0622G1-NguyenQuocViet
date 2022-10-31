package com.example.controller;


import com.example.dTo.FacilityDto;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FuramaController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listFacility")
    public String lisFacility(Model model, @PageableDefault(size = 5) Pageable pageable,@RequestParam Optional<String> key) {
        String keywordVal = key.orElse("");
        Page<Facility> facilities = this.iFacilityService.findAllByFacilityName(keywordVal, pageable);
        model.addAttribute("facility", facilities);
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        model.addAttribute("keywordVal", keywordVal);
        return "facility/list";
    }

    @GetMapping("/addFacility")
    public String addFacility(Model model) {
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/saveAddFacility")
    public String saveAddFacility(Model model, @ModelAttribute("facility") @Validated FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        facilityDto.validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            return "facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        FacilityType facilityType = new FacilityType();
        facilityType.setFacilityTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setFacilityType(facilityType);

        RentType rentType = new RentType();
        rentType.setRentTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setRentType(rentType);

        iFacilityService.add(facility);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/listFacility";
    }
}
