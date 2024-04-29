package org.example;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostOfficeServiceImpl implements PostOfficeService{
    private final PostOfficeRepository postOfficeRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PostOfficeServiceImpl.class);

    public PostOfficeServiceImpl(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    public void create(PostOffice postOffice) {
        log.info("Save new post office");
        postOfficeRepository.save(postOffice);
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

