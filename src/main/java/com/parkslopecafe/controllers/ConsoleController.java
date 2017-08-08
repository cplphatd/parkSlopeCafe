package com.parkslopecafe.controllers;

import com.parkslopecafe.models.StoreStatus;
import com.parkslopecafe.services.StoreStatusService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * <p>The <code>ConsoleController</code> class handles requests regarding the admin console.</p>
 *
 * @author David Ryan Alviola
 * @since August 2017
 */
@Controller
public class ConsoleController {

    @Autowired
    StoreStatusService storeStatusService;

    @GetMapping("/console")
    public String showAdminConsole(Model model) {
        StoreStatus storeStatus = storeStatusService.getStoreStatus();
        model.addAttribute("storeStatus", storeStatus);

        return "console/adminConsole";
    }

    @GetMapping("/changeStoreStatus/{storeIsOpen}")
    public @ResponseBody void changeStoreStatus(@PathVariable String storeIsOpen) {
        System.out.println(storeIsOpen);

        if(storeIsOpen.equals("true")) {
            storeStatusService.changeStoreStatus(true);
        } else {
            storeStatusService.changeStoreStatus(false);
        }
    }
}
