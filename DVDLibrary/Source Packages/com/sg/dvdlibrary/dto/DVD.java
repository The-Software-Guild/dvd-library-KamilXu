package com.sg.dvdlibrary.dto;

public class DVD {
    private String titleDVD;
    private String releaseDate;
    private String ratingMPAA;
    private String directorName;
    private String studioName;
    private String remarkNote;

    public DVD(String titleDVD) {
        this.titleDVD = titleDVD;
    }
    public String gettitleDVD() {
        return titleDVD;
    }

    public String getreleaseDate() {
        return releaseDate;
    }
    
    public void setTitle(String titleDVD) {
        this.titleDVD = titleDVD;
    }

    public void setreleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getratingMPAA() {
        return ratingMPAA;
    }

    public void setratingMPAA(String ratingMPAA) {
        this.ratingMPAA = ratingMPAA;
    }

    public String getdirectorName() {
        return directorName;
    }

    public void setdirectorName(String directorName) {
        this.directorName = directorName;
    }   
    
    public String getstudioName() {
        return studioName;
    }

    public void setstudioName(String studioName) {
        this.studioName = studioName;
    }   
    
    public String getremarkNote() {
        return remarkNote;
    }

    public void setremarkNote(String remarkNote) {
        this.remarkNote = remarkNote;
    }   
}