package org.example;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.isActive(), userDTO.getRoles()); /*User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .roles(dto.getRoles())
                .build();*/
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public List<User> readAll() {
        return repository.findAll();
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
/*   private final DepartureRepository departureRepository;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    private EmailService emailService;
    public UserServiceImpl(DepartureRepository departureRepository, EmailService emailService) {
        this.departureRepository = departureRepository;
        this.emailService = emailService;
    }

    public void create(Departure departure) {
        log.info("Save new departure");
        departureRepository.save(departure);
        emailService.sendNotification(departure);
    }

    public List<Departure> readAll() {
        log.info("Read all departures");
        return departureRepository.findAll();
    }

    public Departure read(Long id) {
        log.info("Read departure with id = {}", id);
        return departureRepository.getReferenceById(id);
    }

    public boolean delete(Long id) {
        log.info("Delete departure with id = {}", id);
        departureRepository.deleteById(id);
        return true;
    }

    public List<Departure> filterByType(String type) {
        log.info("Read departures with type = {}", type);
        return departureRepository.findAllByType(type);
    }

    public List<Departure> filterByTypeAndDate(String type, String date) {
        log.info("Read departure with type = {} and date = {} ", type, date);
        return departureRepository.findAllByTypeAndDepartureDate(type, date);
    }

    public PostOffice getPostOfficeByDeparture(Long departureId) {
        log.info("Get post office id of departure with id = {}", departureId);
        Departure departure = departureRepository.getReferenceById(departureId);
        return departure.getPostOffice();
    }

}

*/