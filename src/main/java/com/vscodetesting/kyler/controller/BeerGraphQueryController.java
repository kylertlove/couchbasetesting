package com.vscodetesting.kyler.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.vscodetesting.kyler.models.Beer;
import com.vscodetesting.kyler.service.IdentityManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class BeerGraphQueryController {

    IdentityManager manager;

    @QueryMapping
    public Beer beerById(@Argument String id) {
        return manager.getBeerById(id);
    }
    
}
