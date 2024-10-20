package com.vscodetesting.kyler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vscodetesting.kyler.models.Beer;
import com.vscodetesting.kyler.service.IdentityManager;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@AllArgsConstructor
@RestController
@RequestMapping("/beers")
public class IdentityController {

    private IdentityManager manager;

    @GetMapping
    public List<Beer> getBeers(@RequestParam(required = false) String type) {
        if(type != null && type != "") {
            return manager.getBeersByType(type);
        }
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

    @PutMapping("/{id}")
    public Beer updateBeer(@PathVariable String id, @RequestBody Beer beer) {
        return manager.updateBeer(beer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBeer(@PathVariable String id) {
        manager.deleteBeer(id);
    }
    
}
