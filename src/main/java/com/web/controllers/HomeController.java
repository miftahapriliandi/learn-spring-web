package com.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Product;
import com.web.services.ProductService;

@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model){
        String messages = "Welcome To Spring MVC with Mifth";
        model.addAttribute("msg", messages);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }

    /**
     * @param product
     * @param model
     * @return
     */
    @PostMapping("/save")
    public String save(Product product, Model model){
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }


    @PostMapping("/update")
    public String update(Product product, Model model){
        productService.updateProduct(product);
        return "redirect:/";
    }
}
