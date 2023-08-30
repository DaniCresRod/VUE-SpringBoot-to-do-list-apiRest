package com.example.first.api.controllers;

import com.example.first.api.models.loginModel;
import com.example.first.api.services.loginServices;
import com.example.first.api.services.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class loginControl {

    @Autowired
    private loginServices myService;

    @PostMapping(path="/logo")
    public loginModel getUser(@RequestBody loginModel loginData){

        //Example<loginModel> myLogin=Example.of(loginData);

        return myService.tryLogin(loginData);
    }

    @PostMapping(path="/add")
    public loginModel addUser(@RequestBody loginModel newData){
        return myService.addNewUser(newData);
    }

    @PostMapping(path="/favs")
    public boolean addFavs(@RequestBody loginModel userData){
        return myService.addFavs(userData);
}
}