package com.example.baithi.controller;


import com.example.baithi.dto.MotelDto;
import com.example.baithi.model.Motell;
import com.example.baithi.model.TypePayment;
import com.example.baithi.service.IMotellService;
import com.example.baithi.service.ITypePaymentService;
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

@Controller
@RequestMapping("/")
public class MotelController {

    @Autowired
    private IMotellService motellService;
    @Autowired
    private ITypePaymentService typePaymentService;

    @GetMapping("/listMotel")
    public String listMotel(@RequestParam(defaultValue ="" )
                            String name, String type, Model model,
                            @PageableDefault(size = 3)Pageable pageable){
        model.addAttribute("motel", motellService.findAll(name, type, pageable));
        model.addAttribute("type", typePaymentService.findAll());
        return "/view/list";
    }
    @GetMapping("/deleteMotel")
    public String deleteMotel(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        Motell motell= motellService.findById(deleteId).get();
        motell.setStatus(1);
        motellService.save(motell);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/listMotel";
    }

    @GetMapping("/motelAdd")
    public String modelAdd(Model model){
        model.addAttribute("motelDto", new MotelDto());
        model.addAttribute("type", typePaymentService.findAll());
        return "view/add";
    }

    @PostMapping("/motelSave")
    public String motelSave(@ModelAttribute("motelDto")@Validated MotelDto motelDto,
                            BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes){
        motelDto.validate(motelDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("motelDto", motelDto);
            model.addAttribute("type", typePaymentService.findAll());
            return "/view/add";
        }
        Motell motell= new Motell();
        TypePayment typePayment = typePaymentService.findById(Integer.parseInt(motelDto.getTypePayment()));
        motell.setTypePayment(typePayment);
        BeanUtils.copyProperties(motelDto,motell);
        motellService.save(motell);
        redirectAttributes.addFlashAttribute("message", "Thêm mới  thành công");
        return "redirect:/listMotel";
    }


    @GetMapping("/updateMotel")
    public  String updateMotel(@RequestParam int id, Model model){
        model.addAttribute("motel", motellService.findById(id).get());
        model.addAttribute("type", typePaymentService.findAll());
        return "view/update";
    }
    @PostMapping("/saveUpdateMotel")
    public  String saveUpdateMotel(@ModelAttribute("motel")@Validated MotelDto motelDto,
                                   BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        motelDto.validate(motelDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("type", typePaymentService.findAll());
            return "view/update";
        }
        Motell motell= new Motell();
        TypePayment typePayment = typePaymentService.findById(Integer.parseInt(motelDto.getTypePayment()));
        motell.setTypePayment(typePayment);
        BeanUtils.copyProperties(motelDto,motell);
        motellService.save(motell);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/listMotel";
    }



}
