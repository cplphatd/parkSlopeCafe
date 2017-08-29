package com.parkslopecafe.services;

import com.parkslopecafe.models.StoreStatus;
import com.parkslopecafe.repositories.StoreStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("storeStatusService")
public class StoreStatusService {

    @Autowired
    private StoreStatusRepo storeStatusRepo;

    public StoreStatus getStoreStatus() {
        return storeStatusRepo.findById(1);
    }

    public void changeStoreStatus(boolean storeIsOpen) {
        StoreStatus storeStatus = storeStatusRepo.findById(1);

        if(storeIsOpen) {
            storeStatus.setStoreIsOpen(true);
        } else {
            storeStatus.setStoreIsOpen(false);
        }

        storeStatusRepo.save(storeStatus);
    }

    public void changeStoreDecoration(String decoration) {
        StoreStatus storeStatus = storeStatusRepo.findById(1);

        storeStatus.setDecoration(decoration);

        storeStatusRepo.save(storeStatus);
    }

    public void updateMessage(String message) {
        StoreStatus storeStatus = storeStatusRepo.findById(1);

        storeStatus.setMessage(message);

        storeStatusRepo.save(storeStatus);
    }
}
