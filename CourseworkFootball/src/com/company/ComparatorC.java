package com.company;
import java.util.Comparator;

public class ComparatorC implements Comparator <FootballClub> {
    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        if(o1.getNoPoints()>o2.getNoPoints()) {
            return -1;
        }
        else if(o1.getNoPoints()<o2.getNoPoints()) {
            return 1;
        }
        else {
            int goalDifOne= o1.getScoredGoals()- o1.getNoGoals();
            int goalDifTwo=o2.getScoredGoals()-o2.getNoGoals();
            return Integer.compare(goalDifOne,goalDifTwo);
        }
    }
}