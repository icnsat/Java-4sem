package org.example;

import org.springframework.stereotype.Component;
@Component
public class Flashlight implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Flashlight is turned on");
    }
}
