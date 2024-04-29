package org.example;


import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostOfficeServiceImpl implements PostOfficeService{
    private final PostOfficeRepository postOfficeRepository;

    public PostOfficeServiceImpl(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    public void create(PostOffice postOffice) {
        postOfficeRepository.save(postOffice);
    }


    public List<PostOffice> readAll() {
        return postOfficeRepository.findAll();
    }

    public PostOffice read(Long id) {
        return postOfficeRepository.getReferenceById(id);
    }


    public boolean delete(Long id) {
        postOfficeRepository.deleteById(id);
        return true;
    }

    public List<PostOffice> filterByName(String name) {
        return postOfficeRepository.findAllByName(name);
    }

}

