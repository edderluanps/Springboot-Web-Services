package com.projeto.Springboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.Springboot.entities.enums.OrderStatus;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrderList")
public class Order implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long idOrder;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timeOrder;
    
    private Integer orderStatus;
  
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;
    
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    public Order(Long idOrder, Instant timeOrder, OrderStatus orderStatus, User client) {
        super();
        this.idOrder = idOrder;
        this.timeOrder = timeOrder;
        setOrderStatus(orderStatus);
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

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {     
        if (orderStatus != null){
        this.orderStatus = orderStatus.getCode();
        }
    }
    
    public Set<OrderItem> getItems(){
        return items;
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
