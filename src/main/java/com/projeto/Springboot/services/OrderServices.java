package com.projeto.Springboot.services;

import com.projeto.Springboot.entities.Order;
import com.projeto.Springboot.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {
    
    @Autowired
    private OrderRepository repository;
    
    public List<Order> findAll(){
        return repository.findAll();
        
    }
    
    public Order findById(Long idOrder){
        
        Optional<Order> obj = repository.findById(idOrder);
        return obj.get();
    }
    
}
