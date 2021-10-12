package com.sg.dvdlibrary.dao;

import java.util.List;

import com.sg.dvdlibrary.dto.DVD;

public interface DVDLibraryDao {

   
	DVD addDVD(String titleDVD, DVD DVD)throws DVDLibraryDaoException;

    
    List<DVD> getAllDVDs()throws DVDLibraryDaoException;

   
    DVD getDVD(String titleDVD)throws DVDLibraryDaoException;

    /*
     * Only passing in DVD title because while DVD's having the same title is rare, 
     * it can also happen however I messed around and added the release date function,
     * to not be the same as other DVD's however a DVD can be release with the same,
     * title on the same day so in the end to avoid removing multiple DVDs with the,
     * same title and release date we would have to implement some other function which,
     * there is no time for. There could also be the same movie but different versions of it,
     * with the same title, release date, studio, director, etc. Hence the best thing to do,
     * would be to implement a reference number or Id number for these DVD's.
     */
    DVD removeDVD(String titleDVD) throws DVDLibraryDaoException;
    
    DVD editDVD(String titleDVD) throws DVDLibraryDaoException;
    
    public void writeToDVD() throws DVDLibraryDaoException;
}

