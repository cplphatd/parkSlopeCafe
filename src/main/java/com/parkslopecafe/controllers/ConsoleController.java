package com.parkslopecafe.controllers;

import com.parkslopecafe.models.Beer;
import com.parkslopecafe.models.StoreStatus;
import com.parkslopecafe.models.User;
import com.parkslopecafe.repositories.Users;
import com.parkslopecafe.services.BeerService;
import com.parkslopecafe.services.StoreStatusService;
import com.parkslopecafe.validators.BeerErrorMessageGenerator;
import com.parkslopecafe.validators.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    BeerService beerService;

    @Autowired
    Users userRepository;

    @Autowired
    StringValidator stringValidator;

    @Autowired
    BeerErrorMessageGenerator beerErrorMessageGenerator;

    @GetMapping("/console")
    public String showAdminConsole(Model model) {
        StoreStatus storeStatus = storeStatusService.getStoreStatus();
        model.addAttribute("storeStatus", storeStatus);

        return "console/adminConsole";
    }

    @GetMapping("/changeStoreStatus/{storeIsOpen}")
    public @ResponseBody void changeStoreStatus(@PathVariable String storeIsOpen) {

        if(storeIsOpen.equals("true")) {
            storeStatusService.changeStoreStatus(true);
        } else {
            storeStatusService.changeStoreStatus(false);
        }
    }

    @GetMapping("console/changePassword")
    public String showChangePasswordPage(Model model) {
        User user = userRepository.findOne(1);

        model.addAttribute("user", user);

        return "users/changePassword";
    }

    @GetMapping("/changeStoreDecoration/{decoration}")
    public @ResponseBody void changeStoreDecoration(@PathVariable String decoration) {

        storeStatusService.changeStoreDecoration(decoration);
    }

    @GetMapping("/console/beers")
    public String showBeerConsole(Model model) {
        List<Beer> beerList = beerService.getBeerList();
        model.addAttribute("beerList", beerList);

        return "console/beerConsole";
    }

    @GetMapping("/console/beers/{id}")
    public String getBeerProfile(Model model, @PathVariable("id") int id) {
        Beer beer = beerService.getBeerById(id);
        String[] errorMessages = new String[3];

        model.addAttribute("beer", beer);
        model.addAttribute("errorMessages", errorMessages);

        return "console/beerProfile";
    }

    @PostMapping("/updateBeer/{id}")
    public String updateBeerProfile(@ModelAttribute Beer beer, @PathVariable("id") int id, Model model) {

        //Validate the inputs from beer
        boolean passedValidation = stringValidator.checkIfStringIsValid(beer.getName())
                && stringValidator.checkForSpecialCharacters(beer.getCategory())
                && stringValidator.checkForSpecialCharacters(beer.getDescription());

        //Get any error messages from validation results
        String[] errorMessages = beerErrorMessageGenerator.getErrorMessages(
                stringValidator.checkIfStringIsValid(beer.getName()),
                stringValidator.checkForSpecialCharacters(beer.getCategory()),
                stringValidator.checkForSpecialCharacters(beer.getDescription()));

        if(!passedValidation) {
            model.addAttribute("beer", beer);
            model.addAttribute("errorMessages", errorMessages);

            return "console/beerProfile";
        }

        //Only updates beer if validation is passed
        Beer updatedBeer = beerService.getBeerById(id);

        updatedBeer.setName(beer.getName());
        updatedBeer.setCategory(beer.getCategory());
        updatedBeer.setDescription(beer.getDescription());
        updatedBeer.setPicture(beer.getPicture());

        beerService.updateBeer(updatedBeer);

        return "redirect:/console/beers/{id}";
    }

    @GetMapping("/console/beers/createBeer")
    public String showBeerCreationForm(Model model) {
        Beer beer = new Beer();
        String[] errorMessages = new String[3];

        model.addAttribute("beer", beer);
        model.addAttribute("errorMessages", errorMessages);

        return "console/beerForm";
    }

    @PostMapping("/createBeer")
    public String createBeer(@ModelAttribute Beer beer, Model model) {

        //Validate the inputs from beer
        boolean passedValidation = stringValidator.checkIfStringIsValid(beer.getName())
                && stringValidator.checkForSpecialCharacters(beer.getCategory())
                && stringValidator.checkForSpecialCharacters(beer.getDescription());

        //Get any error messages from validation results
        String[] errorMessages = beerErrorMessageGenerator.getErrorMessages(
                stringValidator.checkIfStringIsValid(beer.getName()),
                stringValidator.checkForSpecialCharacters(beer.getCategory()),
                stringValidator.checkForSpecialCharacters(beer.getDescription()));

        if(!passedValidation) {
            model.addAttribute("beer", beer);
            model.addAttribute("errorMessages", errorMessages);

            return "console/beerForm";
        }

        //Only create beer if validation passed
        beerService.createBeer(beer);

        return "redirect:/console/beers";
    }

    @GetMapping("/deleteBeer/{id}")
    public @ResponseBody void deleteBeer(@PathVariable("id") int id) {
        beerService.deleteBeer(id);
    }

    @GetMapping("/updateStock/{id}/{isInStock}")
    public @ResponseBody void updateStockStatus(@PathVariable("id") int id,
                                                @PathVariable("isInStock") boolean isInStock) {
        beerService.updateStockStatus(id, isInStock);
    }

    @GetMapping("/updateMessage/{message}")
    public @ResponseBody void updateMessage(@PathVariable("message") String message) {
        storeStatusService.updateMessage(message);
    }
}
