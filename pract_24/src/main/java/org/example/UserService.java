package org.example;

import java.util.List;

public interface UserService {
    User addUser(UserDTO dto);

    List<User> readAll();

    User update(User user);

    void delete(Long id);
}
