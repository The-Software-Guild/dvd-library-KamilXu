package com.sg.dvdlibrary.ui;

import java.util.List;

import com.sg.dvdlibrary.dto.DVD;

public class DVDLibraryView {

	private UserIO io;

    public int printMenuAndGetSelection() {
    	io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Search for a DVD");
        io.print("4. Edit a DVD");
        io.print("5. List of DVD's");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public DVD getNewDVDInfo() {
        String titleDVD = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter DVD Release Date in DD/MM/YYYY Format");
        String ratingMPAA = io.readString("Please enter the MPAA Rating");
        String directorName = io.readString("Please enter the Director's Name");
        String studioName = io.readString("Please enter Name of the Studio");
        String remarkNote = io.readString("Please enter Remark/Note");
        
        DVD currentDVD = new DVD(titleDVD);
        currentDVD.setreleaseDate(releaseDate);
        currentDVD.setratingMPAA(ratingMPAA);
        currentDVD.setdirectorName(directorName);
        currentDVD.setstudioName(studioName);
        currentDVD.setremarkNote(remarkNote);
        return currentDVD;
    }
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
    
    public void displayDVDList(List<DVD> DVDList) {
    	int counter = 1;
        for (DVD currentDVD : DVDList) {
            String DVDInfo = String.format("DVD "+ counter +" : %s by %s",
                  currentDVD.gettitleDVD(),
                  currentDVD.getdirectorName());
            counter++;
            io.print(DVDInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD's ===");
    }
    
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String gettitleDVDChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVD DVD) {
        if (DVD != null) {
            io.print("Title: " + DVD.gettitleDVD());
            io.print("Director: " + DVD.getdirectorName());
            io.print("Studio: " + DVD.getstudioName());
            io.print("Release: " + DVD.getreleaseDate());
            io.print("MPAA: " + DVD.getratingMPAA());
            io.print("Note: " + DVD.getremarkNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    public int getDVDEditNumber() {
    	return io.readInt("Please select which Field do you want to Edit.", 1, 6);
    }
    
    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD DVDRecord) {
        if(DVDRecord != null){
          io.print("DVD successfully removed.");
        }else{
          io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displayEditDVDBanner() {
    	io.print("=== Edit DVD ===");
    }
    
    public String editTitle() {
        return io.readString("Please enter the New DVD Title.");
    }
    
    public String editDirector() {
        return io.readString("Please enter the New Director Name.");
    }
    
    public String editStudio() {
        return io.readString("Please enter the New Studio Name.");
    }
    
    public String editRelease() {
        return io.readString("Please enter the New Release Date in DD/MM/YYYY.");
    }
    
    public String editMPAA() {
        return io.readString("Please enter the New MPAA Rating.");
    }
    
    public String editNote() {
        return io.readString("Please enter the New Remark / Note.");
    }
    
    public String displayEnterMessage() {
    	return io.readString("Please hit enter to continue.");
    }
    
    public void displayEditSuccess() {
    	io.print("Succesfully Edited!");
    }
    

    
    
}