package org.example.controllers;

import org.example.entities.Departure;
import org.example.entities.PostOffice;
import org.example.services.DepartureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartureController {
    private final DepartureServiceImpl departureServiceImpl;

    @Autowired
    public DepartureController(DepartureServiceImpl service) {
        this.departureServiceImpl = service;
    }

    @GetMapping(value="/departure/{departureId}/postoffice")
    public @ResponseBody PostOffice getDeparturesPostOffice(@PathVariable("departureId") Long departureId){
        return departureServiceImpl.getPostOfficeByDeparture(departureId);
    }


    @PostMapping(value = "/departure")
    public ResponseEntity<?> create(@RequestBody Departure departure){
        departureServiceImpl.create(departure);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/departure")
    public ResponseEntity<List<Departure>> read() {
        final List<Departure> departures = departureServiceImpl.readAll();
        return departures != null && !departures.isEmpty()
                ? new ResponseEntity<>(departures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/departure/{id}")
    public ResponseEntity<Departure> read(@PathVariable(name="id") long id) {
        final Departure departure = departureServiceImpl.read(id);
        return departure != null
                ? new ResponseEntity<>(departure, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/departure/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = departureServiceImpl.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/departure/filter-by-type/{type}")
    public ResponseEntity<List<Departure>> filterByType(@PathVariable(name="type") String type) {
        final List<Departure> departures = departureServiceImpl.filterByType(type);
        return departures != null && !departures.isEmpty()
                ? new ResponseEntity<>(departures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/departure/filter-by-type-and-date/{type}/{date}")
    public ResponseEntity<List<Departure>> filterByType(@PathVariable(name="type") String type, @PathVariable(name="date") String date) {
        final List<Departure> departures = departureServiceImpl.filterByTypeAndDate(type, date);
        return departures != null && !departures.isEmpty()
                ? new ResponseEntity<>(departures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
