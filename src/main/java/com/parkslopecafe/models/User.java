package com.parkslopecafe.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * <p>The <code>User</code> class stores information about each user. Spring
 * annotations are used to designate the <code>User</code> class as a table and each of its
 * properties as a column. Foreign keys link the user to the donations they make. Getters and
 * setters for each of the properties are present.</p>
 *
 * @author David Ryan Alviola
 * @since August 2017
 */
@Entity
@Table (name = "users")
public class User {

    /**
     * Default constructor for the <code>User</code> class. This constructor is used when
     * creating a new user.
     */
    public User () {

    }

    /**
     * <p>Constructor for <code>User</code> class when retrieving userCopy information from the
     * database. Used as a copy constructor.</p>
     *
     * @param userCopy object with userCopy information
     */
    public User (User userCopy) {

        id = userCopy.id;
        username = userCopy.username;
        password = userCopy.password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Cannot be blank")
    private String username;

    @Column(nullable = false)
    @Size(min = 8, message = "Must be at least 8 characters")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
