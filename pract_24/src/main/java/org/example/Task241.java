package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = HibernateJpaAutoConfiguration.class)
//@EnableJpaRepositories//(basePackages = "com.example.repositories")
//@EntityScan(basePackages = "com.example.entities")
public class Task241 {
    public static void main(String[] args) {
        SpringApplication.run(Task241.class, args);
    }

}