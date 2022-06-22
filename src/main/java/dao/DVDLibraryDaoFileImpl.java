package dao;

import dto.DVD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD tempDVD = dvds.put(title,dvd);
        return tempDVD;
    }

    @Override
    public DVD removeDVD(String title) {
        DVD tempDVD = dvds.remove(title);
        return tempDVD;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String title) {
        return dvds.get(title);
    }
}
