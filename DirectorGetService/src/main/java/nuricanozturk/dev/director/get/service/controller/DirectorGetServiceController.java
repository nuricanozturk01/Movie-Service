package nuricanozturk.dev.director.get.service.controller;

import nuricanozturk.dev.director.get.service.dto.DirectorsWithFullNameDTO;
import nuricanozturk.dev.director.get.service.service.DirectorGetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/read/directors")
public class DirectorGetServiceController
{
    private final DirectorGetService m_directorGetService;

    public DirectorGetServiceController(DirectorGetService directorGetService)
    {
        this.m_directorGetService = directorGetService;
    }

    @GetMapping("find/movie")
    public DirectorsWithFullNameDTO getDirectorsByMovieId(@RequestParam("id") int id)
    {
        return m_directorGetService.findDirectorsByMovieId(id);
    }

}
