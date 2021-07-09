package com.projeto.Springboot.resources;

import com.projeto.Springboot.entities.Category;
import com.projeto.Springboot.services.CategoryServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {
    
    @Autowired
    private CategoryServices service;
    
    
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
        
    }
    
    @GetMapping(value = "/{idCategory}")
    public ResponseEntity<Category> findById(@PathVariable Long idCategory){
        
        Category obj = service.findById(idCategory);
        
        return ResponseEntity.ok().body(obj);
        
    }
    
}
