package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.IProductService;
import vn.codegym.service.impl.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductControler {
    private final IProductService productService=new ProductService();
    @GetMapping("")
    public String index(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("products",productList);
        return "/product/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/product/create";
    }
  @PostMapping("/save")
    public String save(Product product){
        product.setId((int)(Math.random()*10000));
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redierect){
        productService.remove(product);
        redierect.addFlashAttribute("success","Removed Product successfully!\"");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/product/view";
    }
    @GetMapping("/search")
    public String search(@RequestParam String searchName, Model model){
        List<Product> productList= productService.findByName(searchName);
        model.addAttribute("products",productList);
    return "/product/index";
    }
}
