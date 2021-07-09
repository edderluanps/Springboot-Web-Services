package com.projeto.Springboot.services;

import com.projeto.Springboot.entities.Category;
import com.projeto.Springboot.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {
    
    @Autowired
    private CategoryRepository repository;
    
    public List<Category> findAll(){
        return repository.findAll();
        
    }
    
    public Category findById(Long idCategory){
        
        Optional<Category> obj = repository.findById(idCategory);
        return obj.get();
    }
    
}
