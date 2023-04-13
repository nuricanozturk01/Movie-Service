package nuricanozturk.dev.movie.post.service.controller;

import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import nuricanozturk.dev.movie.post.service.service.MoviePostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post/movies")
public class MoviePostServiceController
{
    private final MoviePostService m_service;

    public MoviePostServiceController(MoviePostService service)
    {
        m_service = service;
    }

    @PostMapping("/movie/save")
    public Movie saveMovie(@RequestBody Movie movie)
    {
       return m_service.saveMovie(movie);
    }
}
