package nuricanozturk.dev.director.get.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DirectorsWithFullNameDTO
{
    @JsonProperty("directors")
    public List<DirectorWithFullNameDTO> directors;
}
