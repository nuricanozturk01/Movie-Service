package nuricanozturk.dev.movie.data.repository.jdbc;

import com.karandev.util.data.repository.ICrudRepository;
import nuricanozturk.dev.movie.data.entity.jdbc.Movie;

public interface IMovieRepository extends ICrudRepository<Movie, Long>
{
    Iterable<Movie> getMoviesWithMonth(int mon);

    Iterable<Movie> getMoviesWithYear(int year);
    Iterable<Movie> getMoviesWithMonthAndYear(int month, int year);

    Iterable<Movie> getMoviesBetweenYears(int begin, int end);
    Iterable<Movie> getMoviesByDirectorId(int id);
}
