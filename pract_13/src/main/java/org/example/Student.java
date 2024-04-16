package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${program.student.name}")
    private String name;
    @Value("${program.student.last_name}")
    private String last_name;
    @Value("${program.student.group}")
    private String group;
    @PostConstruct
    public void getStudent(){
        System.out.println("\nName: " + name
                + "\nLastname: " + last_name
                + "\nGroup: " + group + "\n");
    }
}
