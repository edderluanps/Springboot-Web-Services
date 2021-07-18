package com.projeto.Springboot.resources;

import com.projeto.Springboot.entities.User;
import com.projeto.Springboot.services.UserServices;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idUser}").buildAndExpand(obj.getIdUser()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "/{idUser}")
    public ResponseEntity<Void> delete(@PathVariable Long idUser){
        service.delete(idUser);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{idUser}")
    public ResponseEntity<User> update(@PathVariable Long idUser, @RequestBody User obj){
        obj = service.update(idUser, obj);
        return ResponseEntity.ok().body(obj);
    }
    
}