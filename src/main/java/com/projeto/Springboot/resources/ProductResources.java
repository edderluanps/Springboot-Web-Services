package com.projeto.Springboot.resources;

import com.projeto.Springboot.entities.Products;
import com.projeto.Springboot.services.ProductServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {
    
    @Autowired
    private ProductServices service;
    
    
    @GetMapping
    public ResponseEntity<List<Products>> findAll(){
        
        List<Products> list = service.findAll();
        return ResponseEntity.ok().body(list);
        
    }
    
    @GetMapping(value = "/{idProduct}")
    public ResponseEntity<Products> findById(@PathVariable Long idProduct){
        
        Products obj = service.findById(idProduct);
        
        return ResponseEntity.ok().body(obj);
        
    }
    
}
