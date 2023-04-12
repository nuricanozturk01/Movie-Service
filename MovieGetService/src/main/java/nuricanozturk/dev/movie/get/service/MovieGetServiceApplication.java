package nuricanozturk.dev.movie.get.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
public class MovieGetServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MovieGetServiceApplication.class, args);
    }

}
