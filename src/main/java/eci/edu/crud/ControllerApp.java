package eci.edu.crud;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "eci.edu.crud")
public class ControllerApp {


    private static final Logger log = LoggerFactory.getLogger(ControllerApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ControllerApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(PropertyInterface repository) {
        return (args) -> {
            // Mensaje que indica que se buscarán todas las propiedades
            System.out.println("Properties found with findAll():");
            System.out.println("-------------------------------");


            repository.findAll().forEach(property -> {
                System.out.println(property.toString());
            });
            System.out.println("");
        };
    }
}

