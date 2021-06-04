package com.company;

import java.io.Serializable;

public class SportsClub implements Serializable {

    private String clubId;
    private String clubName;
    private String location;
    private int noMembers;

    //constructor
    public SportsClub(String clubId, String clubName, String location, int noMembers) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.location = location;
        this.noMembers = noMembers;
    }

    //getters and setters
    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoMembers() {
        return noMembers;
    }

    public void setNoMembers(int noMembers) {
        this.noMembers = noMembers;
    }

    //toString method for above variables
    public String toString() {
        return "SportsClub >>>  " + "clubId:- " + clubId +  ", clubName:- " + clubName + ", location:- " + location + ", noMembers:- " + noMembers ;
    }

}



