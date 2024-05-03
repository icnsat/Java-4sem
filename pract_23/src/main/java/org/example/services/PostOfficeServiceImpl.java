package org.example.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entities.PostOffice;
import org.example.interfaces.PostOfficeService;
import org.example.repositories.PostOfficeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PostOfficeServiceImpl implements PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PostOfficeServiceImpl.class);

    private EmailService emailService;
    public PostOfficeServiceImpl(PostOfficeRepository postOfficeRepository, EmailService emailService) {
        this.postOfficeRepository = postOfficeRepository;
        this.emailService = emailService;
    }

    public void create(PostOffice postOffice) {
        log.info("Save new post office");
        postOfficeRepository.save(postOffice);
        emailService.sendNotification(postOffice);
    }

    public List<PostOffice> readAll() {
        log.info("Read all post offices");
        return postOfficeRepository.findAll();
    }

    public PostOffice read(Long id) {
        log.info("Read post office with id = {}", id);
        return postOfficeRepository.getReferenceById(id);
    }

    public boolean delete(Long id) {
        log.info("Delete post office with id = {} ", id);
        postOfficeRepository.deleteById(id);
        return true;
    }

    public List<PostOffice> filterByName(String name) {
        log.info("Read post office with name = {} ", name);
        return postOfficeRepository.findAllByName(name);
    }

}

