package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public HashFile hashFile(){
        String src = "source.txt";
        String dest = "target.txt";
        return new HashFile(src, dest);
    }
}
