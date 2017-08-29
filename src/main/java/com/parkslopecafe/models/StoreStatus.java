package com.parkslopecafe.models;

import javax.persistence.*;

//TODO: javadoc
/**
 * @author David Ryan Alviola
 * @since August 2017
 */

@Entity
@Table (name = "store_status")
public class StoreStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean storeIsOpen;

    @Column(columnDefinition = "string default none")
    private String decoration;

    @Column(length = 1000)
    private String message;

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

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
