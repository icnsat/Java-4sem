package org.example.controllers;

import org.example.entities.Role;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {


    @Autowired
    public RegistrationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration() {
        logger.info("Registration cite visited");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        logger.info("Post-");
        User userFromDb = userRepo.findByUsername(user.getUsername());
        logger.info("existence testing{}", userFromDb);
        if (userFromDb != null) {
            logger.info("exists");
            model.put("message", "User exists!");
            return "registration";
        }
        logger.info("doesn't exist!");
        user.setRoles(Collections.singleton(Role.USER));
        logger.info("role applied");
        user.setActive(true);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        logger.info("added");
        return "redirect:/login";
    }
}