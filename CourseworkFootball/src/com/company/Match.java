package com.company;

import java.io.Serializable;

public class Match implements Serializable {

    private String teamOneName;
    private String teamSecName;
    private int teamOneGoalCount;
    private int teamSecGoalCount;
    private Date date;

    public Match() {
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamSecName() {
        return teamSecName;
    }

    public void setTeamSecName(String teamSecName) {
        this.teamSecName = teamSecName;
    }

    public int getTeamOneGoalCount() {
        return teamOneGoalCount;
    }

    public void setTeamOneGoalCount(int teamOneGoalCount) {
        this.teamOneGoalCount = teamOneGoalCount;
    }

    public int getTeamSecGoalCount() {
        return teamSecGoalCount;
    }

    public void setTeamSecGoalCount(int teamSecGoalCount) {
        this.teamSecGoalCount = teamSecGoalCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

