package dto;

import java.time.LocalDate;

public class DVD {
    private String title;
    private LocalDate releaseDate;
    private double rating;
    private Director director;
    private Studio studio;
    private String note;

    public DVD(String title, LocalDate releaseDate, double rating, Director director, Studio studio, String note) {
        this.title = title;
        this.releaseDate =releaseDate;
        this.rating = rating;
        this.director = director;
        this.studio = studio;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
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

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDirector(String firstName, String lastName) {
        this.director.setFirstName(firstName);
        this.director.setLastName(lastName);
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}
