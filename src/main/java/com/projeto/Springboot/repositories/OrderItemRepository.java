package com.projeto.Springboot.repositories;

import com.projeto.Springboot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}