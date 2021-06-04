package com.company;

public class SchoolFootballClub extends FootballClub {

    private String schoolName;
    private String schoolLocation;


    public SchoolFootballClub(String clubId, String clubName, String location, int noMembers, int noWins, int noDraws, int noDefeats, int noGoals, int scoredGoals, int noPoints, int noMatches, String schoolName, String schoolLocation) {
        super(clubId, clubName, location, noMembers, noWins, noDraws, noDefeats, noGoals, scoredGoals, noPoints, noMatches);
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
    }

    //Defining setters and getters for schoolName and schoolLocation
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String toString() {
        return  "schoolName:- " + schoolName + ", schoolLocation:- " + schoolLocation ;
    }

}
