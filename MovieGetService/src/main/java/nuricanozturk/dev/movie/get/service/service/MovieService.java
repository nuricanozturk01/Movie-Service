package nuricanozturk.dev.movie.get.service.service;

import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import nuricanozturk.dev.movie.get.service.dto.MovieWithoutIdDTO;
import nuricanozturk.dev.movie.get.service.dto.MoviesWithoutIdDTO;
import nuricanozturk.dev.movie.get.service.mapper.IMovieWithoutIdMapper;
import org.springframework.stereotype.Service;

import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class MovieService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieWithoutIdMapper m_movieWithoutIdMapper;

    public MovieService(MovieServiceHelper movieServiceHelper,
                        IMovieWithoutIdMapper movieWithoutIdMapper)
    {
        m_movieWithoutIdMapper = movieWithoutIdMapper;
        m_movieServiceHelper = movieServiceHelper;
    }

    public long getCount()
    {
        return m_movieServiceHelper.getCount();
    }

    public MoviesWithoutIdDTO getMoviesWithMonth(int month)
    {
        return m_movieWithoutIdMapper.toMoviesWithoutIdDTO(toList(m_movieServiceHelper.getMoviesWithMonth(month), m_movieWithoutIdMapper::toMovieWithoutIdDTO));
    }

    public MoviesWithoutIdDTO getMoviesWithYear(int year)
    {
        return m_movieWithoutIdMapper.toMoviesWithoutIdDTO(toList(m_movieServiceHelper.getMoviesWithYear(year), m_movieWithoutIdMapper::toMovieWithoutIdDTO));
    }

    public MoviesWithoutIdDTO getMoviesWithMonthAndYear(int month, int year)
    {
        return m_movieWithoutIdMapper.toMoviesWithoutIdDTO(toList(m_movieServiceHelper.getMoviesWithMonthAndYear(month,year), m_movieWithoutIdMapper::toMovieWithoutIdDTO));
    }

    public MoviesWithoutIdDTO getMoviesBetweenYears(int begin, int end)
    {
        return m_movieWithoutIdMapper.toMoviesWithoutIdDTO(toList(m_movieServiceHelper.getMoviesBetweenYears(begin,end), m_movieWithoutIdMapper::toMovieWithoutIdDTO));
    }

    public MoviesWithoutIdDTO getMoviesByDirectorId(int id)
    {
        return m_movieWithoutIdMapper.toMoviesWithoutIdDTO(toList(m_movieServiceHelper.getMoviesByDirectorId(id), m_movieWithoutIdMapper::toMovieWithoutIdDTO));
    }

    public MovieWithoutIdDTO findById(Long id)
    {
        return m_movieWithoutIdMapper.toMovieWithoutIdDTO(m_movieServiceHelper.findById(id));
    }
}
