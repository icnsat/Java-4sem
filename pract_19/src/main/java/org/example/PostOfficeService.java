package org.example;

import java.util.List;

public interface PostOfficeService {
    void create(PostOffice postOffice);
    List<PostOffice> readAll();
    PostOffice read(Long id);
    boolean delete(Long id);
    List<PostOffice> filterByName(String name);
}
