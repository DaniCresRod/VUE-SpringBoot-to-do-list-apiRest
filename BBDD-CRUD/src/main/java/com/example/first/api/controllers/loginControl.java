package com.example.first.api.controllers;

import com.example.first.api.models.loginModel;
import com.example.first.api.services.loginServices;
import com.example.first.api.services.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class loginControl {

    @Autowired
    private loginServices myService;

    @GetMapping(path="/logo")
    public loginModel getUser(@RequestBody loginModel loginData){

        Example<loginModel> myLogin=Example.of(loginData);

        return myService.tryLogin(myLogin);
    }
}
