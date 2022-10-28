package com.example.controller;

import com.example.dTo.CartDto;
import com.example.dTo.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto intCart() {
        return new CartDto();
    }

    @GetMapping("")
    public ModelAndView showShop(Model model, @CookieValue(value = "idProduct", defaultValue = "-1")
    Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        return new ModelAndView("/product/list", "productList", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 360);
        cookie.setPath("/");
        return new ModelAndView("product/detail", "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
