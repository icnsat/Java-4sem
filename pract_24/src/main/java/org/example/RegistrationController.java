package org.example;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RegistrationController {

    private final UserServiceImpl service;

    public RegistrationController(UserServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ResponseEntity<List<User>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(service.addUser(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(service.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/registration/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }

}
   /* @Autowired
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
}*/