package com.example.first.api.controllers;

import com.example.first.api.models.models;
import com.example.first.api.services.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class controllers {

    @Autowired
    services myService;

    @GetMapping()
    public ArrayList<models> getProducts(@RequestParam(required = false) String type){
        return myService.getProducts(type);
    }


    @PostMapping
    public models setProduct(@RequestBody models newProduct){
        return myService.setProduct(newProduct);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return myService.deleteProduct(id);
    }

    @PutMapping(path="/update/{id}")
    public models changeProduct(@RequestBody int id, @RequestBody models newProduct){
        return myService.setProduct(myService.changeProduct(id, newProduct));
    }
}
