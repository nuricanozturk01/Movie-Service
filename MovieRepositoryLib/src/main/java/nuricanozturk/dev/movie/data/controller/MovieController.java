package nuricanozturk.dev.movie.data.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController
{
    private final MovieServiceHelper m_serviceHelper;

    public MovieController(MovieServiceHelper serviceHelper)
    {
        m_serviceHelper = serviceHelper;
    }

    @GetMapping("movie/count")
    public long getCount()
    {
        return m_serviceHelper.getCount();
    }

    @GetMapping("find/sdate/month")
    Iterable<Movie> getMoviesWithMonth(@RequestParam("m") int m)
    {
        return m_serviceHelper.getMoviesWithMonth(m);
    }

    @GetMapping("find/sdate/year")
    Iterable<Movie> getMoviesWithYear(@RequestParam("y") int y)
    {
        return m_serviceHelper.getMoviesWithYear(y);
    }
}
