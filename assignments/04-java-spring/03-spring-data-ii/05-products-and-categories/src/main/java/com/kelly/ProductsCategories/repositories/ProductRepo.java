package com.kelly.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.ProductsCategories.models.Category;
import com.kelly.ProductsCategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category categories);
}
