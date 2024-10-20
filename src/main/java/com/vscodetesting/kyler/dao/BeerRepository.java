package com.vscodetesting.kyler.dao;

import com.vscodetesting.kyler.models.Beer;
import java.util.List;

public interface BeerRepository {
    Beer findById(String id);

    Beer save(Beer beer);

    Beer update(String id, Beer beer);

    void delete(String id);

    List<Beer> findAll();

    List<Beer> findByType(String type);

} 
