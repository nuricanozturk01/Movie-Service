package nuricanozturk.dev.director.post.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
public class DirectorPostServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DirectorPostServiceApplication.class, args);
    }

}
