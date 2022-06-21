package controller;

import dao.DVDLibraryDao;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class DVDLibraryController {
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {

    }
}
