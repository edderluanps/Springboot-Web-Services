package com.projeto.Springboot.services;

import com.projeto.Springboot.entities.User;
import com.projeto.Springboot.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll(){
        return repository.findAll();
        
    }
    
    public User findById(Long idUser){
        
        Optional<User> obj = repository.findById(idUser);
        return obj.get();
    }
    
}
