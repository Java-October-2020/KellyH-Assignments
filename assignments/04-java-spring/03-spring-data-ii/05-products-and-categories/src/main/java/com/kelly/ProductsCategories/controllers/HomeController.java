package com.kelly.ProductsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelly.ProductsCategories.models.Category;
import com.kelly.ProductsCategories.models.Product;
import com.kelly.ProductsCategories.services.CategoryService;
import com.kelly.ProductsCategories.services.ProductService;

@Controller

public class HomeController{

	@Autowired
	private CategoryService cServ;
	@Autowired 
	private ProductService pServ;
	
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/products/new";
		}
		else {
			pServ.createProduct(p);
			return "redirect:/products/"+ p.getId();
		}
	}
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category c, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/categories/new";
		}
		else {
			cServ.createCategory(c);
			return "redirect:/categories/"+ c.getId();
		}
	}
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product p = pServ.findOneById(id);
		model.addAttribute("product", p);
		List<Category> pCategories = p.getCategories();
		model.addAttribute("pCategories", pCategories);
		List<Category> c = cServ.categoriesNotIn(p);
		model.addAttribute("notCategories", c);
		return "show.jsp";
		
	}
	@PostMapping("/addCategory/{id}")
	public String addCategory(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
		List<Category> c = product.getCategories();
		Product p = pServ.findOneById(id);
		Category addedCategory = c.get(0);
		pServ.addCategory(addedCategory, p);
		return "redirect:/products/"+id;
		
	}
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category c = cServ.findOneById(id);
		model.addAttribute("category", c);
		List<Product> cProducts = c.getProducts();
		model.addAttribute("cProducts", cProducts);
		List<Product> p = pServ.productsNotIn(c);
		model.addAttribute("notProducts", p);
		return "showCategory.jsp";
	}
	@PostMapping("/addProduct/{id}")
	public String addProduct(@PathVariable("id") Long id, @ModelAttribute("category") Category category) {
		List<Product> p = category.getProducts();
		Category c = cServ.findOneById(id);
		Product addedProduct = p.get(0);
		System.out.println(addedProduct.getName());
		cServ.addProduct(addedProduct, c);
		return "redirect:/categories/"+id;
		
	}
}