package nuricanozturk.dev.director.post.service.contorller;

import nuricanozturk.dev.director.post.service.service.DirectorPostService;
import nuricanozturk.dev.movie.data.entity.jdbc.Director;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post/directors")
public class DirectorPostServiceController
{
    private final DirectorPostService m_directorPostService;

    public DirectorPostServiceController(DirectorPostService directorPostService)
    {
        m_directorPostService = directorPostService;
    }

    @PostMapping("director/save")
    public Director saveDirector(@RequestBody Director director)
    {
        return m_directorPostService.saveDirector(director);
    }
}
