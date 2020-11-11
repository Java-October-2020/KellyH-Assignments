package com.kelly.ProductsCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.ProductsCategories.models.Category;
import com.kelly.ProductsCategories.models.Product;
import com.kelly.ProductsCategories.repositories.ProductRepo;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepo pRepo;
	//create
	public Product createProduct(Product p) {
		return this.pRepo.save(p);
	}
	//read
	public List<Product> findAll(){
		return this.pRepo.findAll();
	}
	
	public Product findOneById(Long id){
		return this.pRepo.findById(id).orElse(null);
	}
	//update
	public Product updateProduct(Product updatedProduct) {
		return this.pRepo.save(updatedProduct);
	}
	//delete
	public void deleteRecord(Long id) {
		this.pRepo.deleteById(id);
	}
	
	//add categories
	public void addCategory(Category c, Product p) {
		List<Category> allCat = p.getCategories();
		allCat.add(c);
		this.pRepo.save(p);
	}
	public List<Product> productsNotIn(Category categories){
		return pRepo.findByCategoriesNotContains(categories);
	}
}