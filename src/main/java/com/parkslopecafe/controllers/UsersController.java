package com.parkslopecafe.controllers;

import com.parkslopecafe.models.User;
import com.parkslopecafe.repositories.Roles;
import com.parkslopecafe.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>The <code>UsersController</code> class handles navigation to user related pages:
 * login, console.</p>
 *
 * @author David Ryan Alviola
 * @since August 2017
 */
@Controller
public class UsersController {

    //Injected classes
    private Users usersRepository;
    private PasswordEncoder encoder;
    private Roles rolesRepository;

    /**
     * <p>Constructor for the <code>UsersController</code> class.</p>
     *
     * @param usersRepository interface with methods that query the database
     * @param encoder used to encrypt the user's password
     * @param rolesRepository interface used to assign roles
     */
    @Autowired
    public UsersController(Users usersRepository, PasswordEncoder encoder, Roles rolesRepository) {
        this.usersRepository = usersRepository;
        this.encoder = encoder;
        this.rolesRepository = rolesRepository;
    }

    /**
     * <p>The <code>showLoginForm</code> method displays the login page.</p>
     *
     * @return displays the login/registration page
     */
    @GetMapping("/login")
    public String showLoginForm() {

        return "users/login";
    }
}
