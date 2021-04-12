package com.example.reStore.controller;

import com.example.reStore.models.Manufacturer;
import com.example.reStore.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping(value = "/api/manufacturer")
    public ResponseEntity<?> create(@RequestBody Manufacturer manufacturer) {
        manufacturerService.create(manufacturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/manufacturer")
    public ResponseEntity<?> findAll() {
        final List<Manufacturer> manufacturerList = manufacturerService.findAll();

        return manufacturerList != null && !manufacturerList.isEmpty()
                ? new ResponseEntity<>(manufacturerList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/manufacturer/{id}")
    public ResponseEntity<Optional<Manufacturer>> find(@PathVariable(name = "id") Long id) {
        final Optional<Manufacturer> manufacturer = manufacturerService.find(id);

        return manufacturer.isPresent()
                ? new ResponseEntity<>(manufacturer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/manufacturer/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Manufacturer> manufacturer = manufacturerService.find(id);
        manufacturerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
