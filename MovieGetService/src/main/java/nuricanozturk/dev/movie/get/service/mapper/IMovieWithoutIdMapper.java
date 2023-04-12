package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.get.service.dto.MovieWithoutIdDTO;
import nuricanozturk.dev.movie.get.service.dto.MoviesWithoutIdDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieWithoutIdMapperImpl", componentModel = "spring")
public interface IMovieWithoutIdMapper
{
    MovieWithoutIdDTO toMovieWithoutIdDTO(Movie movie);

    default MoviesWithoutIdDTO toMoviesWithoutIdDTO(List<MovieWithoutIdDTO> movies)
    {
        var dto = new MoviesWithoutIdDTO();
        dto.movies = movies;
        return dto;
    }
}
