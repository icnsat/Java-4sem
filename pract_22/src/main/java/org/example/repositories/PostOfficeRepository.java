package org.example.repositories;

import org.example.entities.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
    List<PostOffice> findAllByName(String name);
}
