package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.entity.Product;
import com.ashokit.repo.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer productId,Model model ) {
		repo.deleteById(productId);
		model.addAttribute("products",repo.findAll());
		return "data";
	}
	@GetMapping("/edit")
	public String edit(@RequestParam("id") Integer id,Model model) {
		model.addAttribute("products",repo.findById(id));
		return "index";
	}

	@GetMapping("/products")
	public String loadProducts(Model model) {
		model.addAttribute("products", repo.findAll());
		return "data";
	}
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("products",new Product());
		return "index";
	}
	@PostMapping("/save")
	public String handleSave(@Validated @ModelAttribute("products") Product p,BindingResult result,  Model model) {
		if (result.hasErrors()) {
            return "index";
        }
		p = repo.save(p);
        if(p.getProductId()!=null) {
        	model.addAttribute("msg","product saved...");
        }
		return "index";
}
}
