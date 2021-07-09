package com.projeto.Springboot.repositories;

import com.projeto.Springboot.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long>{
    
}