package com.parkslopecafe.services;

import com.parkslopecafe.models.Beer;
import com.parkslopecafe.repositories.BeerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("beerService")
public class BeerService {

    @Autowired
    BeerRepo beerRepo;

    public List<Beer> getBeerList() {
        return beerRepo.findAll();
    }

    public Beer getBeerById(int id) {
        return beerRepo.findOne(id);
    }
}
