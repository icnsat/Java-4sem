package org.example.repositories;

import org.example.entities.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long> {
    List<Departure> findAllByType(String type);
    List<Departure> findAllByTypeAndDepartureDate(String type, String departureDate);
}
