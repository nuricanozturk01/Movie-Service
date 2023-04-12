package nuricanozturk.dev.director.get.service.service;

import nuricanozturk.dev.director.get.service.dto.DirectorsWithFullNameDTO;
import nuricanozturk.dev.director.get.service.mapper.IDirectorWithFullNameMapper;
import nuricanozturk.dev.movie.data.dal.DirectorServiceHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static nuricanozturk.dev.movie.data.BeanName.DIRECTOR_SERVICE_HELPER;
import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class DirectorGetService
{
    private final DirectorServiceHelper m_directorServiceHelper;
    private final IDirectorWithFullNameMapper m_directorWithFullNameMapper;

    public DirectorGetService(@Qualifier(DIRECTOR_SERVICE_HELPER) DirectorServiceHelper directorServiceHelper,
                              IDirectorWithFullNameMapper directorWithFullNameMapper)
    {
        m_directorWithFullNameMapper = directorWithFullNameMapper;
        m_directorServiceHelper = directorServiceHelper;
    }
    public DirectorsWithFullNameDTO findDirectorsByMovieId(int id)
    {
        return m_directorWithFullNameMapper.toDirectorsWithoutIdDTO(toList(m_directorServiceHelper.findDirectorsByMovieId(id), m_directorWithFullNameMapper::toDirectorWithoutIdDTO));
    }

}
