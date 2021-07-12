package com.projeto.Springboot.entities.pk;

import com.projeto.Springboot.entities.Order;
import com.projeto.Springboot.entities.Products;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderItemPk implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "Order_ID")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "Product_ID")    
    private Products product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.order);
        hash = 67 * hash + Objects.hashCode(this.product);
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
        final OrderItemPk other = (OrderItemPk) obj;
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
    
    
}
