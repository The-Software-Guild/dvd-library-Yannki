package dao;

import dto.DVD;

import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(String title, DVD dvd);

    DVD removeDVD(String title);

    DVD editDVD(String title, DVD dvd);

    List<DVD> getAllDVDs();

    DVD getDVD(String title);
}
