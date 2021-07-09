package com.projeto.Springboot.testes;

import com.projeto.Springboot.entities.Category;
import com.projeto.Springboot.entities.Order;
import com.projeto.Springboot.entities.Products;
import com.projeto.Springboot.entities.User;
import com.projeto.Springboot.entities.enums.OrderStatus;
import com.projeto.Springboot.repositories.CategoryRepository;
import com.projeto.Springboot.repositories.OrderRepository;
import com.projeto.Springboot.repositories.ProductRepository;
import com.projeto.Springboot.repositories.UserRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class Testconfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category c1 = new Category(null, "Eletros");
        Category c2 = new Category(null, "Computers");
        Category c3 = new Category(null, "Smartphones");
        
        Products p1 = new Products(0, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Products p2 = new Products(0, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Products p3 = new Products(0, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Products p4 = new Products(0, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Products p5 = new Products(0, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        
        User u1 = new User(null, "Jose", "jose@email.com", "12124545", "pass123");
        User u2 = new User(null, "Mary", "mary@email.com", "759584", "yram123");
        
        Order o1 = new Order(null, Instant.parse("2020-06-20T19:53:00Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-06-20T19:53:00Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2020-06-20T19:53:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        
        userRepository.saveAll(Arrays.asList(u1,u2));
        
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        
    }
    
}