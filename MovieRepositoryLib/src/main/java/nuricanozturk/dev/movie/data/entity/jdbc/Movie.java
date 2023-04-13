package nuricanozturk.dev.movie.data.entity.jdbc;

import java.time.LocalDate;

public class Movie
{
    private long movie_id;
    private String name;
    private LocalDate scene_date;
    private int rating;
    private double cost;
    private float imdb;


    public Movie(long movie_id, String name, LocalDate scene_date, int rating, double cost, float imdb)
    {
        this.movie_id = movie_id;
        this.name = name;
        this.scene_date = scene_date;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getScene_date() {
        return scene_date;
    }

    public void setScene_date(LocalDate scene_date) {
        this.scene_date = scene_date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public float getImdb() {
        return imdb;
    }

    public void setImdb(float imdb) {
        this.imdb = imdb;
    }
}
