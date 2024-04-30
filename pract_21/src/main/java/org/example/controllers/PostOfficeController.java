package org.example.controllers;

import org.example.entities.PostOffice;
import org.example.services.PostOfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostOfficeController {
    private final PostOfficeServiceImpl postOfficeServiceImpl;

    @Autowired
    public PostOfficeController(PostOfficeServiceImpl service) {
        this.postOfficeServiceImpl = service;
    }

    @PostMapping(value = "/postoffice")
    public ResponseEntity<?> create(@RequestBody PostOffice office){
        postOfficeServiceImpl.create(office);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/postoffice")
    public ResponseEntity<List<PostOffice>> read() {
        final List<PostOffice> offices = postOfficeServiceImpl.readAll();
        return offices != null && !offices.isEmpty()
                ? new ResponseEntity<>(offices, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/postoffice/{id}")
    public ResponseEntity<PostOffice> read(@PathVariable(name="id") long id) {
        final PostOffice postOffice = postOfficeServiceImpl.read(id);
        return postOffice != null
                ? new ResponseEntity<>(postOffice, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/postoffice/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = postOfficeServiceImpl.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/postoffice/filter-by-name/{name}")
    public ResponseEntity<List<PostOffice>> filterByName(@PathVariable(name="name") String name) {
        final List<PostOffice> offices = postOfficeServiceImpl.filterByName(name);
        return offices != null && !offices.isEmpty()
                ? new ResponseEntity<>(offices, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
