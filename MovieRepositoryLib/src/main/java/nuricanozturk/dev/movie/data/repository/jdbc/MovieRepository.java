package nuricanozturk.dev.movie.data.repository.jdbc;

import aj.org.objectweb.asm.Type;
import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static nuricanozturk.dev.movie.data.repository.jdbc.Query.*;
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

    @Override
    public Iterable<Movie> getMoviesBetweenYears(int begin, int end) {
        var movies = new ArrayList<Movie>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("b", begin);
        paramMap.put("e", end);

        m_namedParameterJdbcTemplate.query(SQL_MOVIE_SCENE_DATE_BETWEEN_YEAR_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> getMoviesByDirectorId(int id)
    {
        var movies = new ArrayList<Movie>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("id", id);
        m_namedParameterJdbcTemplate.query(SQL_MOVIE_BY_DIRECTOR_ID_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillMovies(rs, movies));

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
    @Override
    public <S extends Movie> S save(S movie)
    {
        var count = count();
        movie.setMovie_id(count + 1);

        var paramSource = new BeanPropertySqlParameterSource(movie);
        paramSource.registerSqlType("movie_id", Types.BIGINT);
        paramSource.registerSqlType("name", Types.VARCHAR);
        paramSource.registerSqlType("scene_date", Types.DATE);
        paramSource.registerSqlType("rating", Types.BIGINT);
        paramSource.registerSqlType("cost", Types.REAL);
        paramSource.registerSqlType("imdb", Types.FLOAT);

        m_namedParameterJdbcTemplate.update(SQL_MOVIE_SAVE_QUERY.getQuery(), paramSource);

        return movie;
    }

    @Override
    public Optional<Movie> findById(Long aLong)
    {
        var movies = new ArrayList<Movie>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("id", aLong);
        m_namedParameterJdbcTemplate.query(SQL_MOVIE_FIND_BY_ID_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return Optional.ofNullable(movies.get(0));
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
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }


}
