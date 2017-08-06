package com.parkslopecafe.controllers;

import com.parkslopecafe.models.StoreStatus;
import com.parkslopecafe.repositories.StoreStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>The <code>ConsoleController</code> class handles requests regarding the admin console.</p>
 *
 * @author David Ryan Alviola
 * @since August 2017
 */
@Controller
public class ConsoleController {

    @Autowired
    StoreStatusRepo storeStatusRepo;

    @GetMapping("/console")
    public String showAdminConsole(Model model) {
        StoreStatus storeStatus = storeStatusRepo.findById(1);
        model.addAttribute("storeStatus", storeStatus);

        return "console/adminConsole";
    }
}
