package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.Role;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
public class AuthController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /*@GetMapping("/web-home")
    public String getIndexPage() {
        return "home";
    }

    /**
     * @ModelAttribute — аннотация, которая связывает параметр метода или
     * возвращаемое значение метода с именованным атрибутом модели, а затем предоставляет его веб-представлению.
     * */

    /*@GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }*/

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User user1 = userRepository.findUserByUsername(user.getUsername());
        if (user1 != null){
            model.put("message", "User exists");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        String encpas = passwordEncoder.encode(user.getPassword());
        user.setPassword(encpas);
        userRepository.save(user);
        return "redirect:/login";
    }
}