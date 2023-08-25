package com.example.first.api.services;

import com.example.first.api.models.models;
import com.example.first.api.repositories.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class services {

    @Autowired
    repositories myRepo;


    public ArrayList<models> getProducts(String type) {
        if (type == null || type.isEmpty()) {
            return new ArrayList<>((Collection) myRepo.findAll());
        } else {
            return new ArrayList<>(myRepo.findByProdType(type));
        }
    }


    public models getOneProduct(int id){
        try{
            return myRepo.findById(id).orElse(null);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String deleteProduct(int id) {
        try{
            myRepo.deleteById(id);
            return "Record "+id+" was successfully deleted.";
        }
        catch(Exception e){
            return "Unable to delete record: \n"+e.getMessage();
        }
    }

    public models setProduct(models newProduct) {
        try{
           return myRepo.save(newProduct);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public models changeProduct(int id, models newProduct) {
        try{
            models toUpdateProduct= myRepo.findById(id).get();
            toUpdateProduct.setProdType(newProduct.getProdType());
            toUpdateProduct.setProdMessage(newProduct.getProdMessage());
            toUpdateProduct.setProdSize(newProduct.getProdSize());
            toUpdateProduct.setProdSize(newProduct.getProdSize());
            toUpdateProduct.setProdColor(newProduct.getProdColor());

            return toUpdateProduct;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
