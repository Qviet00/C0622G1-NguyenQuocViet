package com.example.controller;


import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.TypeCustomer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ITypeCustomerService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


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

    @GetMapping("/listCustomer")
    public String searchTypeAndName(@RequestParam(defaultValue = "") String name, String email, String type, Model model,
                                    @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customer", customerService.findAllByNameAndAdress(name, email, type, pageable));
        model.addAttribute("type", typeCustomerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/customerAdd")
    public String CustomerAdd(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("type", typeCustomerService.findAll());
        return "customer/add";
    }

    @PostMapping("/customerSave")
    public String saveCustomer(@ModelAttribute("customerDto") @Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("type", typeCustomerService.findAll());
            return "customer/add";
        }
        Customer customer = new Customer();
        TypeCustomer typeCustomer = typeCustomerService.findById(Integer.parseInt(customerDto.getTypeCustomer()));
        customer.setTypeCustomer(typeCustomer);
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới OK");
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
    public String saveUpdateCustomer(@ModelAttribute("customer") @Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
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
