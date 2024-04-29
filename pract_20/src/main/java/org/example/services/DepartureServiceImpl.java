package org.example.services;


import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.Departure;
import org.example.entities.PostOffice;
import org.example.interfaces.DepartureService;
import org.example.repositories.DepartureRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class DepartureServiceImpl implements DepartureService {
    private final DepartureRepository departureRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartureServiceImpl.class);

    public DepartureServiceImpl(DepartureRepository departureRepository) {
        this.departureRepository = departureRepository;
    }

    public void create(Departure departure) {
        log.info("Save new departure");
        departureRepository.save(departure);
    }

    public List<Departure> readAll() {
        log.info("Read all departures");
        return departureRepository.findAll();
    }

    public Departure read(Long id) {
        log.info("Read departure with id = {}", id);
        return departureRepository.getReferenceById(id);
    }

    public boolean delete(Long id) {
        log.info("Delete departure with id = {}", id);
        departureRepository.deleteById(id);
        return true;
    }

    public List<Departure> filterByType(String type) {
        log.info("Read departures with type = {}", type);
        return departureRepository.findAllByType(type);
    }

    public List<Departure> filterByTypeAndDate(String type, String date) {
        log.info("Read departure with type = {} and date = {} ", type, date);
        return departureRepository.findAllByTypeAndDepartureDate(type, date);
    }

    public PostOffice getPostOfficeByDeparture(Long departureId) {
        log.info("Get post office id of departure with id = {}", departureId);
        Departure departure = departureRepository.getReferenceById(departureId);
        return departure.getPostOffice();
    }

}

