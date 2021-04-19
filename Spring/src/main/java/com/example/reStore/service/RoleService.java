package com.example.reStore.service;

import com.example.reStore.models.Role;
import com.example.reStore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void create(Role role){
        roleRepository.save(role);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Optional<Role> find(Long id){
        return roleRepository.findById(id);
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }
}
