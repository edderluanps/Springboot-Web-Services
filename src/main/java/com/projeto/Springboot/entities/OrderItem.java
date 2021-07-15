package com.projeto.Springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Springboot.entities.pk.OrderItemPk;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Item")
public class OrderItem implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Products product, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    
    public void setOrder(Order order){
        id.setOrder(order);
        
    }
    
    @JsonIgnore
    public Products getProduct(){
        return id.getProduct();
    }
    
    public void setProduct(Products product){
        id.setProduct(product);
        
    }    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
