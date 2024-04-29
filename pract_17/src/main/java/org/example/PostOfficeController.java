package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostOfficeController {
    private final PostOfficeService postOfficeService;

    @Autowired
    public PostOfficeController(PostOfficeService service) {
        this.postOfficeService = service;
    }

    @PostMapping(value = "/postoffice")
    public ResponseEntity<?> create(@RequestBody PostOffice office){
        postOfficeService.create(office);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }/*

    @PostMapping(value = "/postoffice")
    public ResponseEntity<?> create (@RequestParam MultiValueMap<String, String> formData){
        String name = formData.getFirst("name");
        String city_name = formData.getFirst("city_name");

        PostOffice office = new PostOffice();
        office.setName(name);
        office.setCityName(city_name);

        postOfficeService.create(office);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    @GetMapping(value="/postoffice")
    public ResponseEntity<List<PostOffice>> read() {
        final List<PostOffice> offices = postOfficeService.readAll();
        return offices != null && !offices.isEmpty()
                ? new ResponseEntity<>(offices, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/postoffice/{id}")
    public ResponseEntity<PostOffice> read(@PathVariable(name="id") long id) {
        final PostOffice postOffice = postOfficeService.read(id);
        return postOffice != null
                ? new ResponseEntity<>(postOffice, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/postoffice/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = postOfficeService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value="/postoffice/filter-by-name/{name}")
    public ResponseEntity<List<PostOffice>> filterByName(@PathVariable(name="name") String name) {
        final List<PostOffice> offices = postOfficeService.filterByName(name);
        return offices != null && !offices.isEmpty()
                ? new ResponseEntity<>(offices, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
