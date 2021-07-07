package com.projeto.Springboot.testes;

import com.projeto.Springboot.entities.User;
import com.projeto.Springboot.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Jose", "jose@email.com", "12124545", "pass123");
        User u2 = new User(null, "Mary", "mary@email.com", "759584", "yram123");
        
        userRepository.saveAll(Arrays.asList(u1,u2));
        
    }
    
}