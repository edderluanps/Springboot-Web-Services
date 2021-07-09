package com.projeto.Springboot.repositories;

import com.projeto.Springboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}