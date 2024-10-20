package com.vscodetesting.kyler.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.vscodetesting.kyler.dao.BeerRepository;
import com.vscodetesting.kyler.models.Beer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class IdentityManager {

    private BeerRepository beerRepository;

    
    public Beer getBeerById(String id) {
        return beerRepository.findById(id);
    }

    public List<Beer> getBeers() {
        return beerRepository.findAll();
    }

    public Beer createBeer(Beer beer) {
        return beerRepository.save(beer);
    }

}
