package nuricanozturk.dev.movie.data.repository.jdbc;

import com.karandev.util.data.repository.ICrudRepository;
import nuricanozturk.dev.movie.data.BeanName;
import nuricanozturk.dev.movie.data.entity.jdbc.Director;
import nuricanozturk.dev.movie.data.entity.jdbc.DirectorWithFullName;
import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


public interface IDirectorRepository extends ICrudRepository<Director, Long>
{
    Iterable<Movie> findMoviesByDirectorId(int id);
    Iterable<DirectorWithFullName> findDirectorsByMovieId(int id);
}
