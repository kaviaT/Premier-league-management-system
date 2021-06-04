package com.company;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    static public Scanner input = new Scanner(System.in);
    static public List<FootballClub> lisOfClubs = new ArrayList<>();
    static public List<Match> matchList = new ArrayList<>();

    public void displayMenu() {
        //Display Menu
        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1) Press and Enter Number 1 to Add a Club to Premier League");
            System.out.println("2) Press and Enter Number 2 to Delete a Club from Premier League");
            System.out.println("3) Press and Enter Number 3 to Display various Statistics for a Club");
            System.out.println("4) Press and Enter Number 4 to Display the Premier League Table");
            System.out.println("5) Press and Enter Number 5 to Play a Match");
            System.out.println("6) Press and Enter Number 6 to Save data to a Text File");
            System.out.println("7) Press and Enter Number 7 to Open the GUI");
            System.out.println("------------------------------------------------------------------");
            System.out.print("(*) Press and Enter your Choice:");
            String userChoice = input.next();
            switch (userChoice) {
                case "1":
                    addClub();  //calling addClub Method
                    break;
                case "2":
                    deleteClub(); //calling deleteClub method
                    break;
                case "3":
                    displayStat(); //calling displayStat method
                    break;
                case "4":
                    displayTable(); //calling displayTable method
                    break;
                case "5":
                    playMatch();   //play a random match
                    break;
                case "6":
                    saveMatch();  //save to a file
                    break;
                case "7":
                    new JFXPanel(); //GUI
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            gui(); //calling the gui Method
                        }
                    });
                    break;
                default:
                    System.out.println("Please Enter a Valid Number");
            }
        }
    }

    //adding a Club
    @Override
    public void addClub() {
        System.out.println("Add a Club");
        System.out.println("------------");

        System.out.print("Enter the Id Number of the Club:");
        String clbId = input.next();
        for (SportsClub club : lisOfClubs) {  //checking the whether the same id is registered
            if (club.getClubId().equals(clbId)) {
                System.out.println("This Id number is Registered!");
                return;
            }
        }

        //asking the Name, Location and Number of the Members in the Club
        System.out.print("Enter the Name of the Club:");
        String clbName = input.next();

        System.out.print("Enter the Location of the Club:");
        String clbLoc = input.next();

        System.out.print("Enter the Number of Members of the Club:");
        int clbMembers = input.nextInt();

        SportsClub sportsClub = new FootballClub(clbId, clbName, clbLoc, clbMembers, 0, 0, 0, 0, 0, 0, 0);
        lisOfClubs.add((FootballClub) sportsClub); //adding the Club to the List
        System.out.println("*** Club Added Successfully! ***");

    }

    //deleting a existing club
    @Override
    public void deleteClub() {
        System.out.println("Delete a Club");
        System.out.print("Enter the Id number of the Club:");
        String delId = input.next();

        for (SportsClub club : lisOfClubs) {
            if (club.getClubId().equals(delId)) {
                lisOfClubs.remove(club); //deleting a club by the Id
                System.out.println("The Club ID which " + club.getClubId() + " is Deleted!");
                return;
            }
        }
        System.out.println("Please Enter a Valid Club!"); //will display when user did not enter a valid club
    }

    //displaying the statistics for a selected club
    @Override
    public void displayStat() {
        System.out.println("Display Statistics");

        System.out.print("Enter the Club name here:"); //asking user to enter the club name
        String clbName = input.next();

        for (FootballClub club : lisOfClubs) {
            if (club.getClubName().equals(clbName)) { //check whether club is in the arraylist
                //displaying all the statistics
                System.out.println("Club " + club.getClubName() + " won " + club.getNoWins() + " matches");// number of wins
                System.out.println("Club " + club.getClubName() + " Lost " + club.getNoDefeats() + " matches"); // lost matches
                System.out.println("Club " + club.getClubName() + " Drawn " + club.getNoDraws() + " matches"); // Drawn matches
                System.out.println("Club " + club.getClubName() + " Received " + club.getNoGoals() + " goals"); // Received goals
                System.out.println("Club " + club.getClubName() + " Scored " + club.getScoredGoals() + " goals"); //scored goals
                System.out.println("Club " + club.getClubName() + " got " + club.getNoPoints() + " Points"); // number of points
                System.out.println("Club " + club.getClubName() + " already played " + club.getNoMatches() + " matches");  //played matches
                return;
            }
        }
        System.out.println("Please Enter a Valid Club name");
    }

    @Override
    public void displayTable() {
        //creating the column names
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Club Id", "Club Name", "Location", "Members", "Wins", "Draws", "Lost", "Received Goals", "Scored Goals", "Points", "Matches Played", "Goal Difference");

        //displaying the table
        Collections.sort(lisOfClubs,new ComparatorC());
        for (FootballClub club : lisOfClubs) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                    club.getClubId(), club.getClubName(), club.getLocation(), club.getNoMembers(), club.getNoWins(), club.getNoDraws(), club.getNoDefeats(), club.getNoGoals(), club.getScoredGoals(), club.getNoPoints(), club.getNoMatches(), (club.getScoredGoals() - club.getNoGoals()));
        }
        System.out.println("That's all!!!");
    }


    @Override
    public void playMatch() {

        //asking the Date, Names and the goals of two Clubs
        System.out.print("Enter the Year:");
        int year = input.nextInt();

        System.out.print("Enter the Month:");
        int month = input.nextInt();

        System.out.print("Enter the date:");
        int day = input.nextInt();

        Date date = new Date(day, month, year); //passing them to the Date constructor

        System.out.print("Enter Team One Name:");
        String team1 = input.next();
        FootballClub teamOne = null;
        for (FootballClub footballClub : lisOfClubs) {
            if (footballClub.getClubName().equals(team1)) {//check whether team1 is equals to the clubNames
                teamOne = footballClub;
            }
        }
        if (teamOne == null) {
            System.out.println("Please Enter a Valid Club!"); //will print when user enter an invalid club
            return;
        }

        System.out.print("Enter Team Two Name:");
        String team2 = input.next();
        FootballClub teamTwo = null;
        for (FootballClub footballClub : lisOfClubs) {
            if (footballClub.getClubName().equals(team2)) {
                teamTwo = footballClub;
            }
        }
        if (teamTwo == null) {
            System.out.println("Please Enter a Valid Club!");
            return;
        }

        System.out.print("Enter Team One Goals:");
        int teamFst = input.nextInt(); //Team 1 Goals

        System.out.print("Enter Team Two Goals:");
        int teamScnd = input.nextInt(); //Team 2 Goals

        //passing the values using setters
        Match newMatch = new Match();
        newMatch.setDate(date);
        newMatch.setTeamOneName(team1);
        newMatch.setTeamSecName(team2);
        newMatch.setTeamOneGoalCount(teamFst);
        newMatch.setTeamSecGoalCount(teamScnd);
        matchList.add(newMatch);   //adding to arraylist

        //setting the number of matches played
        teamOne.setNoMatches(teamOne.getNoMatches() + 1);
        teamTwo.setNoMatches(teamTwo.getNoMatches()+ 1);

        //adding new goals to past scored goals
        teamOne.setScoredGoals(teamOne.getScoredGoals()+teamFst);
        teamTwo.setScoredGoals(teamTwo.getScoredGoals()+teamScnd);

        //adding newly goals to previous goals(Received)
        teamOne.setNoGoals(teamOne.getNoGoals()+teamScnd);
        teamTwo.setNoGoals(teamTwo.getNoGoals()+teamFst);

        //adding 5 points if won
        if (teamFst > teamScnd) {       //team one wins
            teamOne.setNoPoints(teamOne.getNoPoints() + 5);
            teamOne.setNoWins(teamOne.getNoWins() + 1);
            teamTwo.setNoDefeats(teamTwo.getNoDefeats() + 1);

        } else if (teamFst < teamScnd) {        //team two wins
            teamTwo.setNoPoints(teamTwo.getNoPoints() + 5);
            teamTwo.setNoWins(teamTwo.getNoWins() + 1);
            teamOne.setNoDefeats(teamOne.getNoDefeats() + 1);

        } else {        //when match is drawn
            //adding one point for each team when drawn
            teamOne.setNoPoints(teamOne.getNoPoints() + 1);
            teamTwo.setNoPoints(teamTwo.getNoPoints() + 1);
            teamOne.setNoDraws(teamOne.getNoDraws() + 1);
            teamTwo.setNoDraws(teamTwo.getNoDraws() + 1);
        }
    }

    //method for save data
    @Override
    public void saveMatch() {
        try {
            FileOutputStream save1 = new FileOutputStream("saving.txt");  //creating new txt file listofclubs
            ObjectOutputStream save2 = new ObjectOutputStream(save1);
            save2.writeObject(lisOfClubs);
            save2.flush();
            save2.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Success");

        try {
            FileOutputStream save3 = new FileOutputStream("match.txt");   //creating new txt file for matchlist
            ObjectOutputStream save4 = new ObjectOutputStream(save3);
            save4.writeObject(matchList);
            save4.flush();
            save4.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Success");
    }

    //getting the previous data
    @Override
    public void getSaveData() {   //getting the previous data
        try {
            FileInputStream inputStream = new FileInputStream("saving.txt");
            ObjectInputStream inStream = new ObjectInputStream(inputStream);
            lisOfClubs = (ArrayList<FootballClub>) inStream.readObject();
            inputStream.close();
            inStream.close();

            FileInputStream inputStream2 = new FileInputStream("match.txt");
            ObjectInputStream inStream2 = new ObjectInputStream(inputStream2);
            matchList = (ArrayList<Match>) inStream2.readObject();
            inputStream2.close();
            inStream2.close();

        } catch (EOFException c) {
            System.out.println("");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gui() {
        FxGui.fx();  //calling FxGui class and it's fx method
    }
}


