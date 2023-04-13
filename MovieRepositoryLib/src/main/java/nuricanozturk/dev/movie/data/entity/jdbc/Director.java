package nuricanozturk.dev.movie.data.entity.jdbc;


import java.time.LocalDate;

public class Director
{
    private long director_id;
    private String first_name;
    private String middle_name;
    private String family_name;
    private LocalDate birth_date;
    public Director() {}

    public Director(long director_id, String first_name, String middle_name, String family_name, LocalDate birth_date)
    {
        this.director_id = director_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.family_name = family_name;
        this.birth_date = birth_date;
    }

    public long getDirector_id()
    {
        return director_id;
    }

    public void setDirector_id(long director_id)
    {
        this.director_id = director_id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getMiddle_name()
    {
        return middle_name;
    }

    public void setMiddle_name(String middle_name)
    {
        this.middle_name = middle_name;
    }

    public String getFamily_name()
    {
        return family_name;
    }

    public void setFamily_name(String family_name)
    {
        this.family_name = family_name;
    }

    public LocalDate getBirth_date()
    {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date)
    {
        this.birth_date = birth_date;
    }
}
