package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void getUsers() {
        User user = new User();
        user.setUsername("Vasya");
        User user2 = new User();
        user2.setUsername("Kotya");
        Mockito.when(userRepository.findAllByUsername("Vasya")).thenReturn(user);

        Assertions.assertEquals("Vasya",userRepository.findAllByUsername("Vasya").getUsername());

    }

    @Test
    void saveOrUpdate() {
    }


}