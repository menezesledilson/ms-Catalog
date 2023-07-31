package com.ms.dscatalog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dscatalog.dto.CategoryDTO;
import com.ms.dscatalog.entities.Category;
import com.ms.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll(){
		List <Category> list = repository.findAll();
		
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
// 		List<CategoryDTO> listDTO = new ArrayList<>();
// 		for (Category  cat: list) {
// 			listDTO.add(new CategoryDTO(cat));
// 	}
// 		return listDTO;
	}

}
