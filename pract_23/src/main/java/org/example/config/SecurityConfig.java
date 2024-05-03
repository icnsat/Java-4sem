package org.example.config;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return (request, response, authentication) -> {
            new SimpleUrlAuthenticationSuccessHandler().onAuthenticationSuccess(request, response, authentication);
            addCookie(response, "customCookie", "cookieValue");};
    }

    private void addCookie(HttpServletResponse response, String cookieName, String cookieValue){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/registration").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .successHandler(successHandler())
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select username, password, active from users where username = ?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from users u inner join user_role ur on u.id = ur.user_id where u.username=?");

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

package com.example;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private DataSource dataSource;

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            new SimpleUrlAuthenticationSuccessHandler().onAuthenticationSuccess(request, response, authentication);
            addCookie(response, "customCookie", "cookieValue");
            logger.info("Cookie saved");
        };
    }

    private void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/reg").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .successHandler(successHandler())
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }


    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//
//    private final UserAppService userAppService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public WebSecurityConfig(UserAppService userAppService,PasswordEncoder passwordEncoderT) {
//        this.userAppService = userAppService;
//        this.passwordEncoder = passwordEncoderT;
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        /**
//         * Стандартной и наиболее распространенной реализацией является DaoAuthenticationProvider,
//         * который извлекает сведения о пользователе из простого пользовательского DAO,
//         * доступного только для чтения, — UserDetailsService.
//         * */
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(userAppService);
//        return provider;
//    }
//
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//
//    /*@Bean
//    public InMemoryUserDetailsManager userDetailsService()/*AuthenticationManagerBuilder auth) throws Exception */ /*{
//        //auth.authenticationProvider(daoAuthenticationProvider());
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }*/
//
//    public void/* SecurityFilterChain*/ configure(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> {
//                    request.requestMatchers("/", "/web-home", "/registration", "/login", "/logout")
//                            .permitAll();
//                    request.anyRequest().authenticated();
//                });
//
//
//        http.formLogin(fL -> fL.loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/web-home", true));
//
//        //return http.build();
//        //http.userDetailsService(userDetailsService());
//    }
//
//}
//
//
//






    /*
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsService = new
//                InMemoryUserDetailsManager();
//        userDetailsService.createUser(new User("user",
//                "password", List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//        return userDetailsService;
//    }
}


    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(request -> request.anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }


}







}






/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.httpBasic()
                //.and()//нужно для постмана
                .csrf().disable()//Отключает CSRF Protection, поскольку она не нужна для API
                .authorizeRequests()
                .antMatchers("/", "/web-home", "/registration","/login")//исключение, какие запросы\страницы
                .permitAll()//будут разрешены всем
                .anyRequest()
                .authenticated()//Декларирует, что все запросы к любой конечной точке должны быть авторизованы, иначе они должны быть отклонены.
                .and()
                .formLogin()
                .loginPage("/login").permitAll()//разрешить всем доступ к странице логинизации
                .defaultSuccessUrl("/web-home", true)//по умолчанию страница
                .and()
                .rememberMe()
                .tokenValiditySeconds((int) TimeUnit.MINUTES.toSeconds(5))
                .key("somethingverysecret")
        ;
    }*/
   /* public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new
                InMemoryUserDetailsManager();
        userDetailsService.createUser(new User("user",
                "password", List.of(new SimpleGrantedAuthority("ROLE_USER"))));
        return userDetailsService;
    }*/

    //@Bean
    /*public UserDetailsService userDetailsService() {
        UserDetails user = User.withUserDetails()/withDefaultPasswordEncoder(passwordEncoder)
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/


    /*@Bean
    public DefaultSecurityFilterChain authenticationManager(HttpSecurity http) throws Exception {
        http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userAppService)
                .passwordEncoder(passwordEncoder);
        return http.build();
    }

}
*/