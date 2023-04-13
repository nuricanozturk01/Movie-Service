package nuricanozturk.dev.movie.post.service.service;

import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.jdbc.Movie;
import org.springframework.stereotype.Service;

@Service
public class MoviePostService
{
    private final MovieServiceHelper m_movieServiceHelper;

    public MoviePostService(MovieServiceHelper movieServiceHelper)
    {
        m_movieServiceHelper = movieServiceHelper;
    }

    public Movie saveMovie(Movie movie)
    {
        return m_movieServiceHelper.saveMovie(movie);
    }
}
