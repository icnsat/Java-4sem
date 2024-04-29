package org.example;


import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartureServiceImpl implements DepartureService{
    private final DepartureRepository departureRepository;

    public DepartureServiceImpl(DepartureRepository departureRepository) {
        this.departureRepository = departureRepository;
    }

    public void create(Departure departure) {
        departureRepository.save(departure);
    }

    public List<Departure> readAll() {
        return departureRepository.findAll();
    }

    public Departure read(Long id) {
        return departureRepository.getReferenceById(id);
    }


    public boolean delete(Long id) {
        departureRepository.deleteById(id);
        return true;
    }

    public List<Departure> filterByType(String type) {
        return departureRepository.findAllByType(type);
    }

    public List<Departure> filterByTypeAndDate(String type, String date) {
        return departureRepository.findAllByTypeAndDepartureDate(type, date);
    }

    public PostOffice getPostOfficeByDeparture(Long departureId) {
        Departure departure = departureRepository.getReferenceById(departureId);
        return departure.getPostOffice();
        /*PostOffice office = session.createQuery("from Departure where id = :id", Departure.class).setParameter("id", departureId).getSingleResult().getPostOffice();
        return office;*/
    }

}

