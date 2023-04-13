package nuricanozturk.dev.movie.data.repository.jdbc;

import nuricanozturk.dev.movie.data.BeanName;
import nuricanozturk.dev.movie.data.entity.jdbc.Director;
import nuricanozturk.dev.movie.data.entity.jdbc.DirectorWithFullName;
import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static nuricanozturk.dev.movie.data.BeanName.DIRECTOR_REPOSITORY;
import static nuricanozturk.dev.movie.data.repository.jdbc.Query.*;

@Repository(DIRECTOR_REPOSITORY)
@Lazy
public class DirectorRepository implements IDirectorRepository
{
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public DirectorRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(SQL_DIRECTOR_COUNT_QUERY.getQuery(), rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }
    @Override
    public Iterable<Movie> findMoviesByDirectorId(int id) {
        return null;
    }

    @Override
    public Iterable<DirectorWithFullName> findDirectorsByMovieId(int id) {

        var directors = new ArrayList<DirectorWithFullName>();
        var paramMap = new HashMap<String, Object>();

        paramMap.put("movieId", id);
        m_namedParameterJdbcTemplate.query(SQL_DIRECTOR_BY_MOVIE_ID_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillDirectors(rs, directors));

        return directors;
    }
    private DirectorWithFullName getDirectorWithFullName(ResultSet rs) throws SQLException
    {
        var fullName = rs.getString(1);
        var birthDate = rs.getDate(2).toLocalDate();

        return new DirectorWithFullName(fullName, birthDate);
    }
    private void fillDirectors(ResultSet rs, ArrayList<DirectorWithFullName> directors) throws SQLException
    {
        do
            directors.add(getDirectorWithFullName(rs));
        while (rs.next());
    }

    private Director getDirector(ResultSet rs) throws SQLException
    {
        var directorId = rs.getInt(1);
        var firstName = rs.getString(2);
        var middleName = rs.getString(3);
        var familyName = rs.getString(4);
        var birthDate = rs.getDate(5).toLocalDate();

        return new Director(directorId, firstName, middleName, familyName, birthDate);
    }
    @Override
    public <S extends Director> S save(S entity) {
        var count = count();
        entity.setDirector_id(count + 1);

        var paramSource = new BeanPropertySqlParameterSource(entity);
        paramSource.registerSqlType("director_id", Types.BIGINT);
        paramSource.registerSqlType("first_name", Types.VARCHAR);
        paramSource.registerSqlType("middle_name", Types.VARCHAR);
        paramSource.registerSqlType("family_name", Types.VARCHAR);
        paramSource.registerSqlType("birth_date", Types.DATE);

        m_namedParameterJdbcTemplate.update(SQL_DIRECTOR_SAVE_QUERY.getQuery(), paramSource);

        return entity;
    }

    //----------------------------------------------------------------------------------------------------
    @Override
    public void delete(Director entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(Iterable<? extends Director> entities) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Director> findAll() {
        return null;
    }

    @Override
    public Iterable<Director> findAllById(Iterable<Long> id) {
        return null;
    }

    @Override
    public Optional<Director> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public <S extends Director> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }








}
