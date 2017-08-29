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

    public void updateBeer(Beer beer) {
        beerRepo.save(beer);
    }

    public void createBeer(Beer beer) {

        if(beer.getPicture() == null || beer.getPicture().equals("")) {
            beer.setPicture("https://cdn.filestackcontent.com/rounded_corners/HoZ9sOn2RweEAI94vIFy");
        }
        beer.setInStock(true);

        beerRepo.save(beer);
    }

    public void deleteBeer(int id) {
        beerRepo.delete(id);
    }

    public void updateStockStatus(int id, boolean isInStock) {
        Beer beer = beerRepo.findOne(id);

        beer.setInStock(isInStock);

        beerRepo.save(beer);
    }
}
