package com.devsuperior.dscatalog.tests;

import java.time.Instant;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

public class Factory {
	
	 public static Product createProduct() {
	        Product product = new Product(1L, "Phone", "Good Phone", 800d, "https://img.com/img.png", Instant.parse("2020-03-03T10:23:09.003Z"));
	        product.getCategories().add( new Category(2L,"Eletrocnics"));
	        return product;
	    }

	 public static ProductDTO createProductoDTO() {
		 
		 Product product = createProduct();
		 
		 return new ProductDTO(product, product.getCategories());
	 }
}
