package com.vscodetesting.kyler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vscodetesting.kyler.models.Beer;
import com.vscodetesting.kyler.service.IdentityManager;

import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/beers")
public class IdentityController {

    private IdentityManager manager;

    @GetMapping
    public List<Beer> getBeers() {
        return manager.getBeers();
    }

    @GetMapping("/{id}")
    public Beer getBeerById(@PathVariable String id) {
        return manager.getBeerById(id);
    }

    @PostMapping
    public Beer postMethodName(@RequestBody Beer beer) {
        return manager.createBeer(beer);
    }
    
}
