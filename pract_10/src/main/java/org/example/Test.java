package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Lamp lamp = context.getBean(Lamp.class);
        lamp.doLight();

        Flashlight flashlight = context.getBean(Flashlight.class);
        flashlight.doLight();

        Firefly firefly = context.getBean(Firefly.class);
        firefly.doLight();
    }
}
