package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {
    @Autowired
    public RegistrationController(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
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
        User userFromDb = userRepo.findAllByUsername(user.getUsername());
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

    @GetMapping("/login")
    public String login() {
        logger.info("Login cite visited");
        return "login";
    }

 /*   @PostMapping("/login")
    public String testLogin(User user, Map<String, Object> model) {
        logger.info("Post login-");
        User userFromDb = userRepo.findAllByUsername(user.getUsername());
        logger.info("existence testing{}", userFromDb);
        if (userFromDb != null) {
            logger.info("exists");
            model.put("message", "User exists!");
            return "redirect:/home";
        }
        logger.info("doesn't exist!");

        return "redirect:/login";
    }*/
}