package com.ms.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.dscatalog.entities.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
