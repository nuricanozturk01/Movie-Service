package nuricanozturk.dev.director.get.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
public class DirectorGetServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(DirectorGetServiceApp.class, args);
    }

}
