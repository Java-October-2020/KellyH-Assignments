package com.kelly.ProductsCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.ProductsCategories.models.Category;
import com.kelly.ProductsCategories.models.Product;
import com.kelly.ProductsCategories.repositories.CategoryRepo;

@Service
public class CategoryService{
	
	@Autowired
	private CategoryRepo cRepo;
	//create
	public Category createCategory(Category c) {
		return this.cRepo.save(c);
	}
	//read
	public List<Category> findAll(){
		return this.cRepo.findAll();
	}
	
	public Category findOneById(Long id){
		return this.cRepo.findById(id).orElse(null);
	}
	//update
	public Category updateCategory(Category updatedCategory) {
		return this.cRepo.save(updatedCategory);
	}
	//delete
	public void deleteRecord(Long id) {
		this.cRepo.deleteById(id);
	}
	//add products
	public void addProduct(Product p, Category c) {
		List<Product> allPro = c.getProducts();
		allPro.add(p);
		this.cRepo.save(c);
	}
	public List<Category> categoriesNotIn(Product p){
		return cRepo.findByProductsNotContains(p);
	}
	
}