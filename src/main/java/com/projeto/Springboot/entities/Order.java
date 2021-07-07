package com.projeto.Springboot.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderList")
public class Order implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long idOrder;
    private Instant timeOrder;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;

    public Order() {
    }

    public Order(Long idOrder, Instant timeOrder, User client) {
        super();
        this.idOrder = idOrder;
        this.timeOrder = timeOrder;
        this.client = client;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Instant getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Instant timeOrder) {
        this.timeOrder = timeOrder;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idOrder);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        return true;
    }
    
    
    
}
