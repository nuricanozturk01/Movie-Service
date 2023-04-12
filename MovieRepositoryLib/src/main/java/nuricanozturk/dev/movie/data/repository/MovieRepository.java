package nuricanozturk.dev.movie.data.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static nuricanozturk.dev.movie.data.repository.Query.*;
import static nuricanozturk.dev.movie.data.BeanName.MOVIE_REPOSITORY;

@Repository(MOVIE_REPOSITORY)
@Lazy
public class MovieRepository implements IMovieRepository
{
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public MovieRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(SQL_MOVIE_COUNT_QUERY.getQuery(), rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }
    @Override
    public Iterable<Movie> getMoviesWithMonth(int mon)
    {
        var movies = new ArrayList<Movie>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("mon", mon);
        m_namedParameterJdbcTemplate.query(SQL_MOVIE_SCENE_DATE_MONTH_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> getMoviesWithYear(int year)
    {
        var movies = new ArrayList<Movie>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("year", year);
        m_namedParameterJdbcTemplate.query(SQL_MOVIE_SCENE_DATE_YEAR_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> getMoviesWithMonthAndYear(int month, int year) {
        var movies = new ArrayList<Movie>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("year", year);
        paramMap.put("mon", month);

        m_namedParameterJdbcTemplate.query(SQL_MOVIE_SCENE_DATE_MONTH_YEAR_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    private void fillMovies(ResultSet rs, List<Movie> movies) throws SQLException
    {
        do
            movies.add(getMovie(rs));
        while (rs.next());
    }

    private Movie getMovie(ResultSet rs) throws SQLException
    {
        var movieId = rs.getLong(1);
        var name = rs.getString(2);
        var sceneDate = rs.getDate(3).toLocalDate();
        var rate = rs.getInt(4);
        var cost = rs.getDouble(5);
        var imdb = rs.getFloat(6);

        return new Movie(movieId, name, sceneDate, rate, cost, imdb);
    }


    //----------------------------------------------------------------------------------------------------

    @Override
    public void delete(Movie entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }


}
