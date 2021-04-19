package com.example.reStore.service;

import com.example.reStore.models.Manufacturer;
import com.example.reStore.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public void create(Manufacturer manufacturer){
        manufacturerRepository.save(manufacturer);
    }

    public List<Manufacturer> findAll(){
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> find(Long id){
        return manufacturerRepository.findById(id);
    }

    public void delete(Long id){
        manufacturerRepository.deleteById(id);
    }
}
