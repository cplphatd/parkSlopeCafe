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
}
