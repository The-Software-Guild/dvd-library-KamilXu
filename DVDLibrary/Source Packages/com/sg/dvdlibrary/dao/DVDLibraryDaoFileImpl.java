package com.sg.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sg.dvdlibrary.dto.DVD;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    @Override
    public DVD addDVD(String titleDVD, DVD DVD) throws DVDLibraryDaoException {
    	loadDVD();
    	DVD newDVD = DVDs.put(titleDVD, DVD);
    	writeDVD();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()throws DVDLibraryDaoException {
    	loadDVD();
    	return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD getDVD(String titleDVD)throws DVDLibraryDaoException {
    	loadDVD();
    	return DVDs.get(titleDVD);
    }

    @Override
    public DVD removeDVD(String titleDVD) throws DVDLibraryDaoException {
    	loadDVD();
    	DVD removedDVD = DVDs.remove(titleDVD);
    	writeDVD();
        return removedDVD;
    }
    
    @Override
    public DVD editDVD(String titleDVD) throws DVDLibraryDaoException {
    	loadDVD();
    	return DVDs.get(titleDVD);
    }
    
    private Map<String, DVD> DVDs = new HashMap<>();
    
    public static final String DVD_FILE = "DVD.txt";
    public static final String DELIMITER = "::";

    private DVD unmarshallDVD(String DVDAsText){
        String[] DVDTokens = DVDAsText.split(DELIMITER);
        String titleDVD = DVDTokens[0];
        DVD DVDFromFile = new DVD(titleDVD);
        
        DVDFromFile.setdirectorName(DVDTokens[1]);
        DVDFromFile.setstudioName(DVDTokens[2]);
        DVDFromFile.setreleaseDate(DVDTokens[3]);
        DVDFromFile.setratingMPAA(DVDTokens[4]);
        DVDFromFile.setremarkNote(DVDTokens[5]);
 
        return DVDFromFile;
    }
    
    private void loadDVD() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "Exception Error: Could not load roster data into memory.", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            DVDs.put(currentDVD.gettitleDVD(), currentDVD);
        }
        scanner.close();
    }
    
    private String marshallDVD(DVD aDVD){

        String DVDAsText = aDVD.gettitleDVD() + DELIMITER;

        DVDAsText += aDVD.getdirectorName() + DELIMITER;
        DVDAsText += aDVD.getstudioName() + DELIMITER;
        DVDAsText += aDVD.getreleaseDate() + DELIMITER;
        DVDAsText += aDVD.getratingMPAA() + DELIMITER;
        DVDAsText += aDVD.getremarkNote();
       
        return DVDAsText;
    }
    
    private void writeDVD() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save the DVD data.", e);
        }

        String DVDAsText;
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD currentDVD : DVDList) {
        	DVDAsText = marshallDVD(currentDVD);
            out.println(DVDAsText);
            out.flush();
        }
        out.close();
    }
    
    public void writeToDVD() throws DVDLibraryDaoException{
    	writeDVD();
    }
    
}