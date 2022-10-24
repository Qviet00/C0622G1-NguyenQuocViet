package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/list")
    public String showList(Model model){
        List<Customer> customerList = iCustomerService.findALL();
        model.addAttribute("customerList", customerList);
        return "/views/list";
    }

    @GetMapping("/create-new")
   public ModelAndView newCustomer(){
        return new ModelAndView(
                "/views/create","newCustomer", new Customer());

    }
    @PostMapping("/create-add")
    public String addCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAt){
        iCustomerService.saveCustomer(customer);
        redirectAt.addFlashAttribute("mess","Add new OK");
        return "redirect:/customer/list";
    }
    @GetMapping("/{id}/delete")
    public  String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes){
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","delete OK");
        return "redirect:/customer/list";
    }
}
