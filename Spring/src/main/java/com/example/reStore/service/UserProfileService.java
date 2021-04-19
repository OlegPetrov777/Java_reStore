package com.example.reStore.service;

import com.example.reStore.models.UserProfile;
import com.example.reStore.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public void create(UserProfile userProfile){
        userProfileRepository.save(userProfile);
    }

    public List<UserProfile> findAll(){
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> find(Long id){
        return userProfileRepository.findById(id);
    }

    public void delete(Long id){
        userProfileRepository.deleteById(id);
    }
}
