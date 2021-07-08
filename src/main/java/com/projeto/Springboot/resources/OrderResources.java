package com.projeto.Springboot.resources;

import com.projeto.Springboot.entities.Order;
import com.projeto.Springboot.services.OrderServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {
    
    @Autowired
    private OrderServices service;
    
    
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
        
    }
    
    @GetMapping(value = "/{idOrder}")
    public ResponseEntity<Order> findById(@PathVariable Long idOrder){
        
        Order obj = service.findById(idOrder);
        
        return ResponseEntity.ok().body(obj);
        
    }
    
}
