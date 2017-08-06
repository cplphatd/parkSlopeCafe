package com.parkslopecafe.repositories;

import com.parkslopecafe.models.StoreStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreStatusRepo extends CrudRepository<StoreStatus, Integer> {
    StoreStatus findById(int id);
}
