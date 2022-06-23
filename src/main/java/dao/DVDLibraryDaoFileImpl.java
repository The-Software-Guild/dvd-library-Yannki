package dao;

import dto.DVD;
import dto.Director;
import dto.Studio;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    public static final String DVD_LIBRARY_FILE = "src/main/java/dvdLibrary.txt";
    public static final String DELIMITER = "::";
    public static final String NAME_DELIMITER = ", ";
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadDVDLibrary();
        DVD tempDVD = dvds.put(title,dvd);
        writeDVDLibrary();
        return tempDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadDVDLibrary();
        DVD tempDVD = dvds.remove(title);
        writeDVDLibrary();
        return tempDVD;
    }

    @Override
    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadDVDLibrary();
        DVD tempDVD = dvds.replace(title, dvd);
        writeDVDLibrary();
        return tempDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadDVDLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadDVDLibrary();
        return dvds.get(title);
    }

    private DVD unmarshallDVD(String dvdAsText){
        // studentAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // Title::2000-12-12::3.5::Jack, Morgan::Ghibli::mhe
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String[] directorToken = dvdTokens[3].split(NAME_DELIMITER);

        DVD dvdFromFile = new DVD(
                dvdTokens[0],
                LocalDate.parse(dvdTokens[1]),
                Double.parseDouble(dvdTokens[2]),
                new Director(directorToken[0],directorToken[1]),
                new Studio(dvdTokens[4]),
                dvdTokens[5]
        );

        return dvdFromFile;
    }

    private void loadDVDLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load dvd library data into memory.", e);
        }
        String currentLine;
        DVD currentDVD;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){
        String dvdAsText = aDVD.getTitle() + DELIMITER;

        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        dvdAsText += aDVD.getRating() + DELIMITER;

        dvdAsText += aDVD.getDirector() + DELIMITER;

        dvdAsText += aDVD.getStudio() + DELIMITER;

        dvdAsText += aDVD.getNote();

        return dvdAsText;
    }

    private void writeDVDLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        String dvdsAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            // turn a Student into a String
            dvdsAsText = marshallDVD(currentDVD);
            // write the Student object to the file
            out.println(dvdsAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
