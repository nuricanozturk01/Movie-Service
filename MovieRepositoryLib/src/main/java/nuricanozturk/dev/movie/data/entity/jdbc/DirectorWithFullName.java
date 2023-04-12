package nuricanozturk.dev.movie.data.entity.jdbc;

import java.time.LocalDate;

public class DirectorWithFullName
{
    private String fullName;
    private LocalDate birthDate;
    public DirectorWithFullName(String fullName, LocalDate birthDate)
    {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
