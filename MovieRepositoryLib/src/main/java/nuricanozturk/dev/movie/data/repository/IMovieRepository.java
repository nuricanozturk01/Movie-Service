package nuricanozturk.dev.movie.data.repository;

import com.karandev.util.data.repository.ICrudRepository;
import nuricanozturk.dev.movie.data.entity.Movie;

public interface IMovieRepository extends ICrudRepository<Movie, Long>
{
    Iterable<Movie> getMoviesWithMonth(int mon);

    Iterable<Movie> getMoviesWithYear(int year);
}
