package org.example.controllers;

import org.example.entities.Departure;
import org.example.entities.PostOffice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/departure")
public class DepartureController {
    public static Map<String, Departure> typeOfDeparture = new HashMap<>();

    @RequestMapping("/create")
    @ResponseBody
    public Departure createPhone(
            @RequestParam(name="type", required=false, defaultValue = "SomeType") String type,
            @RequestParam(name="departuredate", required = false, defaultValue = "SomeDate") String departureDate) {
        Departure departure = new Departure(type, departureDate);
        typeOfDeparture.put(type, departure);
        return departure;
    }

    //localhost:8080/departure/create?type=flight&departuredate=12/12/2012
    //localhost:8080/departure/create?type=ride&departuredate=01/03/2024


    @RequestMapping("/get-all")
    @ResponseBody
    public List<Departure> getAllDepartures() {
        return new ArrayList<>(typeOfDeparture.values());
    }

    //localhost:8080/departure/get-all

    @RequestMapping("/delete")
    @ResponseBody
    public List<Departure> deleteDeparture(
            @RequestParam(name="type", required=true) String type) {
        System.out.println();
        typeOfDeparture.remove(type);
        return new ArrayList<>(typeOfDeparture.values());
    }

    //localhost:8080/departure/delete?type=flight

}
