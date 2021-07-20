package com.projeto.Springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "products")
public class Products implements Serializable{

    private static final long SerialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long idProduct;
    private String nameProduct;
    private String descriptionProduct;
    private Double priceproduct;
    private String imgUrl;
    
    @ManyToMany
    @JoinTable(name = "Product_Categories", joinColumns = @JoinColumn(name = "product_id"),            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories = new HashSet<>();
    
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();
    
    public Products() {
    }

    public Products(long idProduct, String nameProduct, String descriptionProduct, Double priceproduct, String imgUrl) {
        super();
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.priceproduct = priceproduct;
        this.imgUrl = imgUrl;
    }

    public long getIdProduct() {
        return idProduct;
    }
    
    @JsonIgnore
    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Double getPriceproduct() {
        return priceproduct;
    }

    public void setPriceproduct(Double priceproduct) {
        this.priceproduct = priceproduct;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }
    
    @JsonIgnore
    public Set<Order> getOrders(){
        Set<Order> set = new HashSet<>();
        for (OrderItem o : items){
            set.add(o.getOrder());        
            
        }
        return set;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (this.idProduct ^ (this.idProduct >>> 32));
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
        final Products other = (Products) obj;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }
    
}
