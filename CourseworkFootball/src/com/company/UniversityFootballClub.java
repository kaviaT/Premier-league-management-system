package com.company;

public class UniversityFootballClub extends FootballClub {

    private String uniName;
    private String uniLocation;

    //constructor for uniName and uniLocation


    public UniversityFootballClub(String clubId, String clubName, String location, int noMembers, int noWins, int noDraws, int noDefeats, int noGoals, int scoredGoals, int noPoints, int noMatches, String uniName, String uniLocation) {
        super(clubId, clubName, location, noMembers, noWins, noDraws, noDefeats, noGoals, scoredGoals, noPoints, noMatches);
        this.uniName = uniName;
        this.uniLocation = uniLocation;
    }

    //getters and setters for above attributes
    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getUniLocation() {
        return uniLocation;
    }

    public void setUniLocation(String uniLocation) {
        this.uniLocation = uniLocation;
    }

    public String toString() {
        return "----University Football Club->>>>>>>>" + "uniName:- " + uniName + ", uniLocation:- " + uniLocation  ;
    }

}
