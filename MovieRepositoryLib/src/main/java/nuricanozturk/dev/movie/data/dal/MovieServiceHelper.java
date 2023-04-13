package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import nuricanozturk.dev.movie.data.repository.jdbc.IMovieRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static nuricanozturk.dev.movie.data.BeanName.*;

@Component(MOVIE_SERVICE_HELPER)
@Lazy
public class MovieServiceHelper
{
    private final IMovieRepository m_movieRepository;

    public MovieServiceHelper(@Qualifier(MOVIE_REPOSITORY) IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }

    public long getCount()
    {
        return m_movieRepository.count();
    }

    public Iterable<Movie> getMoviesWithMonth(int mon)
    {
        return m_movieRepository.getMoviesWithMonth(mon);
    }

    public Iterable<Movie> getMoviesWithYear(int year)
    {
        return m_movieRepository.getMoviesWithYear(year);
    }

    public Iterable<Movie> getMoviesWithMonthAndYear(int month, int year)
    {
        return m_movieRepository.getMoviesWithMonthAndYear(month, year);
    }
    public Iterable<Movie> getMoviesBetweenYears(int begin, int end)
    {
        return m_movieRepository.getMoviesBetweenYears(begin, end);
    }
    public Iterable<Movie> getMoviesByDirectorId(int id)
    {
        return m_movieRepository.getMoviesByDirectorId(id);
    }

    public Movie saveMovie(Movie movie)
    {
        return m_movieRepository.save(movie);
    }
}
