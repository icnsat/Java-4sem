package org.example.interfaces;

import org.example.entities.Departure;
import org.example.entities.PostOffice;

import java.util.List;

public interface DepartureService {
    void create(Departure departure);

    List<Departure> readAll();

    Departure read(Long id);

    boolean delete(Long id);

    List<Departure> filterByType(String type);

    List<Departure> filterByTypeAndDate(String type, String date);

    PostOffice getPostOfficeByDeparture(Long departureId);
}
