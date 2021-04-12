package com.example.reStore.controller;

import com.example.reStore.models.Role;
import com.example.reStore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value = "/api/role")
    public ResponseEntity<?> create(@RequestBody Role role) {
        roleService.create(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/role")
    public ResponseEntity<?> findAll() {
        final List<Role> roleList = roleService.findAll();

        return roleList != null && !roleList.isEmpty()
                ? new ResponseEntity<>(roleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/role/{id}")
    public ResponseEntity<Optional<Role>> find(@PathVariable(name = "id") Long id) {
        final Optional<Role> role = roleService.find(id);

        return role.isPresent()
                ? new ResponseEntity<>(role, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/role/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Role> role = roleService.find(id);
        roleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
