package com.company;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Serializable {

    private int noWins;
    private int noDraws;
    private int noDefeats;
    private int noGoals;
    private int scoredGoals;
    private int noPoints;
    private int noMatches;

    //Constructor with parameters
    public FootballClub(String clubId, String clubName, String location, int noMembers, int noWins, int noDraws, int noDefeats, int noGoals, int scoredGoals, int noPoints, int noMatches) {
        super(clubId, clubName, location, noMembers);
        this.noWins = noWins;
        this.noDraws = noDraws;
        this.noDefeats = noDefeats;
        this.noGoals = noGoals;
        this.scoredGoals = scoredGoals;
        this.noPoints = noPoints;
        this.noMatches = noMatches;
    }

    //getters and setters
    public int getNoWins() {
        return noWins;
    }

    public void setNoWins(int noWins) {
        this.noWins = noWins;
    }

    public int getNoDraws() {
        return noDraws;
    }

    public void setNoDraws(int noDraws) {
        this.noDraws = noDraws;
    }

    public int getNoDefeats() {
        return noDefeats;
    }

    public void setNoDefeats(int noDefeats) {
        this.noDefeats = noDefeats;
    }

    public int getNoGoals() {
        return noGoals;
    }

    public void setNoGoals(int noGoals) {
        this.noGoals = noGoals;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getNoPoints() {
        return noPoints;
    }

    public void setNoPoints(int noPoints) {
        this.noPoints = noPoints;
    }

    public int getNoMatches() {
        return noMatches;
    }

    public void setNoMatches(int noMatches) {
        this.noMatches = noMatches;
    }


    //toString method for above variables
    public String toString() {
        return "Club Stats:-" +
                "noWins:- " + noWins + ", noDraws:- " + noDraws + ", noDefeats:- " + noDefeats + ", noGoals:- " + noGoals + ", score:- " + scoredGoals + ", noPoints:- " + noPoints + ", noMatches:- " + noMatches;
    }
}
