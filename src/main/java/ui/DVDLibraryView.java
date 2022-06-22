package ui;

import dto.DVD;
import dto.Director;
import dto.Studio;

import java.time.LocalDate;
import java.util.List;

public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView (UserIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter Title");
        LocalDate date = io.readDate("Please enter Release Date in format yyyy-mm-dd");
        double rating = io.readDouble("Please enter Rating from 1-10",1,10);
        String directorFirstName = io.readString("Please enter Director First Name");
        String directorLastName = io.readString("Please enter Director Last Name");
        String studioName = io.readString("Please enter Studio");
        String note = io.readString("Please enter Note if any");

        Director director = new Director(directorFirstName,directorLastName);
        Studio studio = new Studio(studioName);

        DVD currentDVD = new DVD(title,date,rating,director,studio,note);

        return currentDVD;
    }

    public void displayAddDVDBanner() {
        io.print("=== Add DVD ===");
    }

    public void displayAddSuccessBanner() {
        io.readString(
                "DVD successfully added.  Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("#Title: %s %nRelease Date: %s %nRating: %.1f",
                currentDVD.getTitle(),
                currentDVD.getReleaseDate(),
                currentDVD.getRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            String.format("#Title: %s %nRelease Date: %s " +
                            "%nRating: %.1f %nDirector: %s %nStudio: %s %nNote: %s",
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getRating(),
                    dvd.getDirector(),
                    dvd.getStudio(),
                    dvd.getNote());
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
