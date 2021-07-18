package com.projeto.Springboot.services;

import com.projeto.Springboot.entities.User;
import com.projeto.Springboot.repositories.UserRepository;
import com.projeto.Springboot.services.exception.DatabaseException;
import com.projeto.Springboot.services.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(idUser));
    }
    
    public User insert(User obj){
        return repository.save(obj);
    }
    
    public void delete(Long idUser) {
        try {
            repository.deleteById(idUser);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(idUser);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    
    }

    public User update(Long idUser, User obj){
        User entity = repository.getOne(idUser);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj){
        entity.setNameUser(obj.getNameUser());
        entity.setEmailUser(obj.getEmailUser());
        entity.setPhoneUser(obj.getPhoneUser());
        
    }
    
}