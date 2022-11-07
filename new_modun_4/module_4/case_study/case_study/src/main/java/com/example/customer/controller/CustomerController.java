package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.model.TypeCustomer;
import com.example.customer.service.ICustomerService;
import com.example.customer.service.ITypeCustomerService;
import com.example.dtoCustomerAndFacility.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class CustomerController {

    @GetMapping
    public String home() {
        return "home";
    }

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITypeCustomerService typeCustomerService;


    @GetMapping("/listCustomer")
    public String searchTypeAndName(@RequestParam(defaultValue = "") String name, String email, String type, Model model,
                                    @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customer", customerService.findAllByNameAndAdress(name, email, type, pageable));
        model.addAttribute("type", typeCustomerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/customerAdd")
    public String customerAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("type", typeCustomerService.findAll());
        return "customer/add";
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
}
