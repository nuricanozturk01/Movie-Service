package nuricanozturk.dev.movie.data.entity;

import java.time.LocalDate;

public class Movie
{
    public long movie_id;
    public String name;
    public LocalDate scene_date;
    public int rating;
    public double cost;
    public float imdb;

    public Movie(long movie_id, String name, LocalDate scene_date, int rating, double cost, float imdb)
    {
        this.movie_id = movie_id;
        this.name = name;
        this.scene_date = scene_date;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }
}
