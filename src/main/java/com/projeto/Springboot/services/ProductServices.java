package com.projeto.Springboot.services;

import com.projeto.Springboot.entities.Products;
import com.projeto.Springboot.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    
    @Autowired
    private ProductRepository repository;
    
    public List<Products> findAll(){
        return repository.findAll();
        
    }
    
    public Products findById(Long idProduct){
        
        Optional<Products> obj = repository.findById(idProduct);
        return obj.get();
    }
    
}
