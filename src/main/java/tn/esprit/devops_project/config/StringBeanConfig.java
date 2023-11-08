package tn.esprit.devops_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringBeanConfig {
    @Bean
    public String myString() {
        return "Hello, World"; // Remplacez cette chaîne par la valeur souhaitée
    }
}
