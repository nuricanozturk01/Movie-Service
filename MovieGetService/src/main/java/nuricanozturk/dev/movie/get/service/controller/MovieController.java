package nuricanozturk.dev.movie.get.service.controller;

import nuricanozturk.dev.movie.get.service.dto.MoviesWithoutIdDTO;
import nuricanozturk.dev.movie.get.service.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies/read")
public class MovieController
{
    private final MovieService m_movieService;

    public MovieController(MovieService movieService)
    {
        m_movieService = movieService;
    }
    @GetMapping("movie/count")
    public long getCount()
    {
        return m_movieService.getCount();
    }

    @GetMapping("find/sdate/month")
    public MoviesWithoutIdDTO getMoviesWithMonth(@RequestParam("m") int m)
    {
        return m_movieService.getMoviesWithMonth(m);
    }
    @GetMapping("find/sdate/year")
    public MoviesWithoutIdDTO getMoviesWithYear(@RequestParam("y") int y)
    {
        return m_movieService.getMoviesWithYear(y);
    }
    @GetMapping("find/sdate/my")
    public MoviesWithoutIdDTO getMoviesWithMonthAndYear(@RequestParam("y") int y, @RequestParam("m") int m)
    {
        return m_movieService.getMoviesWithMonthAndYear(m, y);
    }

    @GetMapping("find/sdate/year/between")
    public MoviesWithoutIdDTO getMoviesBetweenYears(@RequestParam("begin") int begin, @RequestParam("end") int end)
    {
        return m_movieService.getMoviesBetweenYears(begin, end);
    }
    @GetMapping("find/director")
    public MoviesWithoutIdDTO getMoviesByDirectorId(@RequestParam("id") int id)
    {
        return m_movieService.getMoviesByDirectorId(id);
    }

}
