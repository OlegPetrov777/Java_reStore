package com.example.reStore.controller;

import com.example.reStore.models.Model;
import com.example.reStore.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping(value = "/api/model")
    public ResponseEntity<?> create(@RequestBody Model model) {
        modelService.create(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/model")
    public ResponseEntity<?> findAll() {
        final List<Model> modelList = modelService.findAll();

        return modelList != null && !modelList.isEmpty()
                ? new ResponseEntity<>(modelList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/model/{id}")
    public ResponseEntity<Optional<Model>> find(@PathVariable(name = "id") Long id) {
        final Optional<Model> model = modelService.find(id);

        return model.isPresent()
                ? new ResponseEntity<>(model, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/model/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final Optional<Model> model = modelService.find(id);
        modelService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
