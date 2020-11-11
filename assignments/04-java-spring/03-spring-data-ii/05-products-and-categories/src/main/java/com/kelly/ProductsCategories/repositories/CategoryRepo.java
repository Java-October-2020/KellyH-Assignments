package com.kelly.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.ProductsCategories.models.Category;
import com.kelly.ProductsCategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	
	List<Category> findAll();
	
	List<Category> findByProductsNotContains(Product product);
}
