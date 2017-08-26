package com.parkslopecafe.models;

import javax.persistence.*;

//TODO: javadoc
/**
 * @author David Ryan Alviola
 * @since August 2017
 */
@Entity
@Table(name = "beers")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String description;

    @Column
    private String picture;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isInStock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }
}
