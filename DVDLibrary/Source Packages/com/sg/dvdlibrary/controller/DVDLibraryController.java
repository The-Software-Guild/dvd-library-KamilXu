package com.sg.dvdlibrary.controller;


import java.util.List;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
public class DVDLibraryController {


    
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
	        while (keepGoing) {
	            
	            menuSelection = getMenuSelection();
	
	            switch (menuSelection) {
	                case 1:
	                	createDVD();
	                    break;
	                case 2:
	                	removeDVD();
	                    break;
	                case 3:
	                	viewGetDVD();
	                    break;
	                case 4:
	                    editDVD();
	                    break;
	                case 5:
	                	listDVDs();
	                    break;
	                case 6:
	                    keepGoing = false;
	                    break;
	                default:
	                	unknownCommand();
	            }
	
	        }
	        exitMessage();
    } catch(DVDLibraryDaoException e) {
    	view.displayErrorMessage(e.getMessage());
    	}
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.gettitleDVD(), newDVD);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }
    
    private void viewGetDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String titleDVD = view.gettitleDVDChoice();
        DVD DVD = dao.getDVD(titleDVD);
        view.displayDVD(DVD);
    }
    
    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String titleDVD = view.gettitleDVDChoice();
        DVD removedDVD = dao.removeDVD(titleDVD);
        view.displayRemoveResult(removedDVD);
    }
    
    public void editDVD() throws DVDLibraryDaoException {
    	int editField = 0;
        view.displayEditDVDBanner();
        String titleDVD = view.gettitleDVDChoice();
        DVD DVD = dao.getDVD(titleDVD);
        view.displayDVDEdit(DVD);
        editField = getEditSelection();
        switch (editField) {
        case 1:
        	//title
        	String dvdTitle = view.editTitle();
        	DVD.setTitle(dvdTitle);
        	dao.writeToDVD();
            break;
        case 2:
        	//director
        	String dvdDirector = view.editDirector();
        	DVD.setdirectorName(dvdDirector);
        	dao.writeToDVD();
            break;
        case 3:
        	//studio
        	String dvdStudio = view.editStudio();
        	DVD.setstudioName(dvdStudio);
        	dao.writeToDVD();
            break;
        case 4:
            //release
        	String dvdRelease = view.editRelease();
        	DVD.setreleaseDate(dvdRelease);
        	dao.writeToDVD();
            break;
        case 5:
        	//MPAA
        	String dvdMPAA = view.editMPAA();
        	DVD.setratingMPAA(dvdMPAA);
        	dao.writeToDVD();
            break;
        case 6:
            //Note
        	String dvdNote = view.editNote();
        	DVD.setremarkNote(dvdNote);
        	dao.writeToDVD();
            break;
           
        default:
        	unknownCommand();
        }
        view.displayEditSuccess();
        view.displayEnterMessage();
    }
    
    private int getEditSelection() {
        return view.getDVDEditNumber();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    
    
    
    
}