package com.parkslopecafe.controllers;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>The <code>ConsoleController</code> class handles requests regarding the admin console.</p>
 *
 * @author David Ryan Alviola
 * @since August 2017
 */
public class ConsoleController {

    @GetMapping("/console")
    public String showAdminConsole() {
        return "/console/adminConsole";
    }
}
