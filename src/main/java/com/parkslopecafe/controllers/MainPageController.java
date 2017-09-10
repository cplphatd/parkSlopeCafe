package com.parkslopecafe.controllers;

import com.parkslopecafe.models.Beer;
import com.parkslopecafe.models.StoreStatus;
import com.parkslopecafe.services.BeerService;
import com.parkslopecafe.services.StoreStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    StoreStatusService storeStatusService;

    @Autowired
    BeerService beerService;

    @GetMapping("/")
    public String showMainPage(Model model) {
        StoreStatus storeStatus = storeStatusService.getStoreStatus();
        model.addAttribute("storeStatus", storeStatus);

        return "index";
    }

    @GetMapping("/beerList.json")
    public @ResponseBody List<Beer> getBeerList() {
        return beerService.getBeerList();
    }
}
