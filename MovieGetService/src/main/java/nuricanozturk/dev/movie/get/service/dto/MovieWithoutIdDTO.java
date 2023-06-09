package nuricanozturk.dev.movie.get.service.dto;

import java.time.LocalDate;

public class MovieWithoutIdDTO
{
    private String name;
    private LocalDate scene_date;
    private int rating;
    private double cost;
    private float imdb;

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
