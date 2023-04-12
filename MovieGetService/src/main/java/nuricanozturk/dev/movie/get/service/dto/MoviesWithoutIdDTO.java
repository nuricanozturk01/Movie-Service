package nuricanozturk.dev.movie.get.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviesWithoutIdDTO
{
    @JsonProperty("movies")
    public List<MovieWithoutIdDTO> movies;
}
