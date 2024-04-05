package org.example;

import org.springframework.stereotype.Component;
@Component
public class Firefly implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Firefly is flying");
    }
}
