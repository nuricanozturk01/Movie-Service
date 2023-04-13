package nuricanozturk.dev.director.post.service.service;

import nuricanozturk.dev.movie.data.BeanName;
import nuricanozturk.dev.movie.data.dal.DirectorServiceHelper;
import nuricanozturk.dev.movie.data.entity.jdbc.Director;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static nuricanozturk.dev.movie.data.BeanName.DIRECTOR_SERVICE_HELPER;

@Service
public class DirectorPostService
{
    private final DirectorServiceHelper m_directorServiceHelper;

    public DirectorPostService(@Qualifier(DIRECTOR_SERVICE_HELPER) DirectorServiceHelper directorServiceHelper)
    {
        m_directorServiceHelper = directorServiceHelper;
    }

    public Director saveDirector(Director director)
    {
        return m_directorServiceHelper.saveDirector(director);
    }
}
