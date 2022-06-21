package dao;

import dto.DVD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDLibraryDaoImpl implements DVDLibraryDao{
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) {
        return null;
    }

    @Override
    public DVD removeDVD(DVD dvd) {
        return null;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return null;
    }

    @Override
    public DVD getDVD(DVD dvd) {
        return null;
    }

    @Override
    public DVD getDVDbyTitle(String title) {
        return null;
    }
}
