package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.entity.jdbc.Director;
import nuricanozturk.dev.movie.data.entity.jdbc.DirectorWithFullName;
import nuricanozturk.dev.movie.data.repository.jdbc.IDirectorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static nuricanozturk.dev.movie.data.BeanName.DIRECTOR_REPOSITORY;
import static nuricanozturk.dev.movie.data.BeanName.DIRECTOR_SERVICE_HELPER;

@Component(DIRECTOR_SERVICE_HELPER)
@Lazy
public class DirectorServiceHelper
{
    private final IDirectorRepository m_directorRepository;
    public DirectorServiceHelper(@Qualifier(DIRECTOR_REPOSITORY) IDirectorRepository m_directorRepository)
    {
        this.m_directorRepository = m_directorRepository;
    }
    public Iterable<DirectorWithFullName> findDirectorsByMovieId(int id)
    {
        return m_directorRepository.findDirectorsByMovieId(id);
    }

    public Director saveDirector(Director director)
    {
        return m_directorRepository.save(director);
    }
}
