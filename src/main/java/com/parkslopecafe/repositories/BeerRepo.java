package com.parkslopecafe.repositories;

import com.parkslopecafe.models.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepo extends CrudRepository<Beer, Integer> {
    List<Beer> findAll();
}
