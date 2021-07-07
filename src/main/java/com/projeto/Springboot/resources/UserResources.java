package com.projeto.Springboot.resources;

import com.projeto.Springboot.entities.User;
import com.projeto.Springboot.services.UserServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    
    @Autowired
    private UserServices service;
    
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
        
    }
    
    @GetMapping(value = "/{idUser}")
    public ResponseEntity<User> findById(@PathVariable Long idUser){
        
        User obj = service.findById(idUser);
        
        return ResponseEntity.ok().body(obj);
        
    }
    
}
