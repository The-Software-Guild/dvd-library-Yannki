package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
import dto.DVD;
import dto.Director;
import dto.Studio;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

import java.time.LocalDate;
import java.util.List;

public class DVDLibraryController {
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        editDVD();
                        break;
                    case 5:
                        removeDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void addDVD() throws DVDLibraryDaoException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddSuccessBanner();
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }

    private void editDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        if (dvd != null) {
            int selectionEdit = view.printDVDEditSelection();
            switch (selectionEdit) {
                case 1:
                    editRealeaseDate(dvd);
                    break;
                case 2:
                    editRating(dvd);
                    break;
                case 3:
                    editDirector(dvd);
                    break;
                case 4:
                    editStudio(dvd);
                    break;
                case 5:
                    editNote(dvd);
                    break;
                default:
                    editUnknownCommand();
            }
            view.displayDVD(dvd);
        } else {
            view.displayDVDNotFound();
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void editRealeaseDate(DVD dvd) throws DVDLibraryDaoException {
        LocalDate date = view.displayEditReleaseDate();
        dvd.setReleaseDate(date);
        dao.editDVD(dvd.getTitle(),dvd);
        view.displayAddSuccessBanner();
    }

    private void editRating(DVD dvd) throws DVDLibraryDaoException {
        double rating = view.displayEditRating();
        dvd.setRating(rating);
        dao.editDVD(dvd.getTitle(), dvd);
        view.displayAddSuccessBanner();
    }

    private void editDirector(DVD dvd) throws DVDLibraryDaoException {
        Director director = view.displayEditDirector();
        dvd.setDirector(director.getFirstName(), director.getLastName());
        dao.editDVD(dvd.getTitle(), dvd);
        view.displayAddSuccessBanner();
    }

    private void editStudio(DVD dvd) throws DVDLibraryDaoException {
        Studio studio = view.displayEditStudio();
        dvd.setStudio(studio);
        dao.editDVD(dvd.getTitle(), dvd);
        view.displayAddSuccessBanner();
    }

    private void editNote(DVD dvd) throws DVDLibraryDaoException {
        String note = view.displayEditNote();
        dvd.setNote(note);
        dao.editDVD(dvd.getTitle(), dvd);
        view.displayAddSuccessBanner();
    }

    private void editUnknownCommand(){
        view.displayEditUnknownCommandBanner();
    }
}
