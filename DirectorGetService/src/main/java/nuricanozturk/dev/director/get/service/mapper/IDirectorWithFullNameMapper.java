package nuricanozturk.dev.director.get.service.mapper;

import nuricanozturk.dev.director.get.service.dto.DirectorWithFullNameDTO;
import nuricanozturk.dev.director.get.service.dto.DirectorsWithFullNameDTO;
import nuricanozturk.dev.movie.data.entity.jdbc.DirectorWithFullName;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DirectorWithoutIdMapperImpl", componentModel = "spring")
public interface IDirectorWithFullNameMapper
{
    DirectorWithFullNameDTO toDirectorWithoutIdDTO(DirectorWithFullName director);

    default DirectorsWithFullNameDTO toDirectorsWithoutIdDTO(List<DirectorWithFullNameDTO> directors)
    {
        var dto = new DirectorsWithFullNameDTO();
        dto.directors = directors;
        return dto;
    }
}
