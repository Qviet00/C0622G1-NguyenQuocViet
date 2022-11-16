package com.example.baithi.controller;


import com.example.baithi.dto.ProductionDto;
import com.example.baithi.model.Production;
import com.example.baithi.service.INumberProductionService;
import com.example.baithi.service.IProductionService;
import com.example.baithi.service.ITypeProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@RequestMapping("/")
public class ControllerProduction {

    @Autowired
    IProductionService productionService;
    @Autowired
    ITypeProductionService typeProductionService;
    @Autowired
    INumberProductionService numberProductionService;


    @GetMapping("/listProduction")
    public String listProduction(Model model, @PageableDefault(size=3)Pageable pageable){
        model.addAttribute("newProduction", new Production());
        model.addAttribute("productionDto", new ProductionDto());
        model.addAttribute("productionDto", productionService.showListConTract(pageable));
        model.addAttribute("typeProduction", typeProductionService.findAll());
        model.addAttribute("numberProduction",numberProductionService.findAll());

        return "view/list";
    }

}
