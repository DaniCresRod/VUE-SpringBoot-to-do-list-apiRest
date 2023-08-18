package com.example.first.api.controllers;

import com.example.first.api.services.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class controllers {

    @Autowired
    services myServices;


}
