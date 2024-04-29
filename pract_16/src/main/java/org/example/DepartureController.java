package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartureController {
    private final DepartureService departureService;

    @Autowired
    public DepartureController(DepartureService service) {
        this.departureService = service;
    }

    @GetMapping(value="/departure/{departureId}/postoffice")
    public @ResponseBody PostOffice getDeparturesPostOffice(@PathVariable("departureId") Long departureId){
        return departureService.getPostOfficeByDeparture(departureId);
    }


    @PostMapping(value = "/departure")
    public ResponseEntity<?> create(@RequestBody Departure departure){
        departureService.create(departure);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }/*



    @PostMapping(value = "/departure")
    public ResponseEntity<?> create (@RequestParam MultiValueMap<String, String> formData){
        String type = formData.getFirst("type");
        String date = formData.getFirst("date");

        Departure departure = new Departure();
        departure.setType(type);
        departure.setDepartureDate(date);

        departureService.create(departure);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
*/
    @GetMapping(value="/departure")
    public ResponseEntity<List<Departure>> read() {
        final List<Departure> offices = departureService.readAll();
        return offices != null && !offices.isEmpty()
                ? new ResponseEntity<>(offices, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/departure/{id}")
    public ResponseEntity<Departure> read(@PathVariable(name="id") long id) {
        final Departure departure = departureService.read(id);
        return departure != null
                ? new ResponseEntity<>(departure, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/departure/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = departureService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
