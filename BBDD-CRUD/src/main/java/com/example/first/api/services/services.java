package com.example.first.api.services;

import com.example.first.api.models.models;
import com.example.first.api.repositories.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class services {

    @Autowired
    repositories myRepo;


    public ArrayList<models> getProducts() {
    }

    public String deleteProduct(int id) {
    }

    public models setProduct(models newProduct) {
    }

    public models changeProduct(int id, models newProduct) {
    }
}
