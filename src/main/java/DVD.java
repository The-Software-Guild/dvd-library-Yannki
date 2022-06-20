package main.java;

import java.util.Date;

public class DVD {
    private String title;
    private Date releaseDate;
    private double rating;
    private Director director;
    private Studio studio;
    private String note;

    public DVD(String title, Date releaseDate, double rating, Director directorName, Studio studio) {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
        this.setRating(rating);
        this.setDirector(directorName);
        this.setStudio(studio);
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public Director getDirector() {
        return director;
    }

    public Studio getStudio() {
        return studio;
    }

    public String getNote() {
        return note;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
