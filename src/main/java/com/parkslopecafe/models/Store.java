package com.parkslopecafe.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * @author David Ryan Alviola
 * @since August 2017
 */

@Entity
@Table (name = "store_status")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean storeIsOpen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStoreIsOpen() {
        return storeIsOpen;
    }

    public void setStoreIsOpen(boolean storeIsOpen) {
        this.storeIsOpen = storeIsOpen;
    }
}
