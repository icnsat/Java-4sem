/*
//package org.example.services;

//import lombok.extern.slf4j.Slf4j;
//import org.example.entities.User;
//import org.example.entities.UserApp;
//import org.example.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAppService implements UserDetailsService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserAppService.class);
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserAppService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username);
        System.out.println("\n\nUsername:"+ username +"\n\n\n\n\n");
        UserApp applicationUser = new UserApp(userRepository.findUserByUserName(username));
        if (applicationUser.getUser() == null) {
            throw new UsernameNotFoundException(String.format("Username: %s not found", username));
        }
        return applicationUser;
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findUserByUserName(user.getUserName()) != null;
        if (userExists) {
            throw new IllegalStateException(String.format("User with username %s exists", user.getUserName()));
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
        return "login";
    }
}
*/