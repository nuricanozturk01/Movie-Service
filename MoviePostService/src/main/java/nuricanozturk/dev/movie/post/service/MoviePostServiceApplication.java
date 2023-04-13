package nuricanozturk.dev.movie.post.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
public class MoviePostServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MoviePostServiceApplication.class, args);
    }

}
