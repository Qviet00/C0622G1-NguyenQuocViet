package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Customer> customerList = iCustomerService.findALL();
        model.addAttribute("customerList", customerList);
        return "/views/list";
    }

    @GetMapping("/create-new")
    public ModelAndView newCustomer() {
        return new ModelAndView(
                "/views/create", "newCustomer", new Customer());

    }

    @PostMapping("/create-add")
    public String addCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAt) {
        iCustomerService.saveCustomer(customer);
        redirectAt.addFlashAttribute("mess", "Add new OK");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable int id) {
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "delete OK");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customerList", customer);
        return "/views/edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
    redirectAttributes.addAttribute("message","ediT OK");
    iCustomerService.saveCustomer(customer);
    return "redirect:/customer/list";
    }
    @GetMapping("/view/{id}")
    public String viewCustomer(@PathVariable int id,Model model){
        Customer customer =iCustomerService.findById(id);
        List<Customer> customerList= new ArrayList<>();
        customerList.add(customer);
        model.addAttribute("customerList", customerList);
        return "/views/list";
    }
    @GetMapping("/search")
    public String searchCustomer(@RequestParam(value = "firstName") String firstName, Model model){
        List<Customer> customerList = iCustomerService.searchByName(firstName);
        model.addAttribute("customerList",customerList);
        return "/views/list";
    }
}
