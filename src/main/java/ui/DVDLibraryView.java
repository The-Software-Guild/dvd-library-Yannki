package ui;

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
}
