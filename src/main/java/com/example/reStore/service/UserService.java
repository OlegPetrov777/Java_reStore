package com.example.reStore.service;

import com.example.reStore.models.User;
import com.example.reStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(User user){
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> find(Long id){
        return userRepository.findById(id);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}