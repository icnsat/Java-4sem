package org.example;


import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(exclude = HibernateJpaAutoConfiguration.class)
//@EnableJpaRepositories//(basePackages = "com.example.repositories")
//@EntityScan(basePackages = "com.example.entities")
public class Task23 {
    public static void main(String[] args) {
        SpringApplication.run(Task23.class, args);
    }

}