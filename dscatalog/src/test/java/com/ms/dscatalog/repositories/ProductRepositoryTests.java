package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.dao.EmptyResultDataAccessException;


import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;



@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	private  long exintingId;
	private  long nonExistingId;
	
	private long countTotalProdcuts;
	
	@BeforeEach
	void setUp() throws Exception {
		 exintingId = 1L;
		 nonExistingId = 1000L;
		 countTotalProdcuts = 25;
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdsNull() {
		
		Product product =  Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProdcuts + 1, product.getId());
	}

	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		repository.deleteById(exintingId);

		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteShouldEmptyResultDataAccessExceptionQuandoIdNaoExistir() {
	    
	    Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
	        repository.deleteById(nonExistingId);
	    });
	}

}
