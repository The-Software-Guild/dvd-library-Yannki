package main.java;

import java.util.Date;

public class DVD {
    String title;
    Date releaseDate;
    double rating;
    Director directorName;
    Studio studio;
    String note;

    public DVD(String title, Date releaseDate, double rating, Director directorName, Studio studio) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.directorName = directorName;
        this.studio = studio;
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

    public Director getDirectorName() {
        return directorName;
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
}
