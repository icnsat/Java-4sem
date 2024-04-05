package org.example;

import org.springframework.stereotype.Component;
@Component
public class Lamp implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Lamp is lightning");
    }
}
