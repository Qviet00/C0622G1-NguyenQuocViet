package com.example.controller;

import com.example.model.User;
import com.example.service.IUserService;
import com.example.userDto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public String showListUser(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("userList", iUserService.findAll(pageable));
        return "/views/list";
    }

    @GetMapping("/create-new")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/views/create";
    }

    @PostMapping("/create-add")
    public String addCreate(@ModelAttribute("userDto") @Validated UserDto userDto,
                            BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/views/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.create(user);
        return "redirect:/user/list";
    }

    @GetMapping("/edit-new/{id}")
    public String editNew(@PathVariable int id, Model model) {
        model.addAttribute("userDto", iUserService.findById(id).get());
        return "/views/edit";
    }

    @PostMapping("/edit-add")
    public String editAdd(@ModelAttribute("userDto") @Validated UserDto userDto,
                          BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/views/edit";
        }
        User user = new User();
        user.setId(userDto.getId());
        BeanUtils.copyProperties(userDto, user);
        iUserService.create(user);
        return "redirect:/user/list";
    }
}
