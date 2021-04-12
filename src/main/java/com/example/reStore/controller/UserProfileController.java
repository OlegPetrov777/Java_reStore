package com.example.reStore.controller;

import com.example.reStore.models.UserProfile;
import com.example.reStore.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserProfileController {
    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping(value = "/api/userProfile")
    public ResponseEntity<?> create(@RequestBody UserProfile userProfile) {
        userProfileService.create(userProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/userProfile")
    public ResponseEntity<?> findAll() {
        final List<UserProfile> userProfileList = userProfileService.findAll();

        return userProfileList != null && !userProfileList.isEmpty()
                ? new ResponseEntity<>(userProfileList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/userProfile/{id}")
    public ResponseEntity<Optional<UserProfile>> find(@PathVariable(name = "id") Long id) {
        final Optional<UserProfile> userProfile = userProfileService.find(id);

        return userProfile.isPresent()
                ? new ResponseEntity<>(userProfile, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/userProfile/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<UserProfile> userProfile = userProfileService.find(id);
        userProfileService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
