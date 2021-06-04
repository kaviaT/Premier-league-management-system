package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import static com.company.PremierLeagueManager.*;

public class FxGui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    public static void fx() {

        Stage stage=new Stage();
        //creating the tableview and it's columns
        TableView table = new TableView();

        TableColumn clubId = new TableColumn("Club Id");
        clubId.setCellValueFactory(new PropertyValueFactory<>("clubId"));

        TableColumn colName = new TableColumn("Club Name");
        colName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        colName.setPrefWidth(110.0);

        TableColumn colWins = new TableColumn("Wins");
        colWins.setCellValueFactory(new PropertyValueFactory<>("noWins"));
        colWins.setPrefWidth(70.0);

        TableColumn colDraws = new TableColumn("Draws");
        colDraws.setCellValueFactory(new PropertyValueFactory<>("noDraws"));
        colDraws.setPrefWidth(70.0);

        TableColumn colLost = new TableColumn("Lost");
        colLost.setCellValueFactory(new PropertyValueFactory<>("noDefeats"));
        colLost.setPrefWidth(70.0);

        TableColumn colRg = new TableColumn("Received Goals");
        colRg.setCellValueFactory(new PropertyValueFactory<>("noGoals"));
        colRg.setPrefWidth(115.0);

        TableColumn colSg = new TableColumn("Scored Goals");
        colSg.setCellValueFactory(new PropertyValueFactory<>("scoredGoals"));
        colSg.setSortable(false);

        TableColumn colPts = new TableColumn("Points");
        colPts.setCellValueFactory(new PropertyValueFactory<>("noPoints"));

        TableColumn colMatchPly = new TableColumn("Matches Played");
        colMatchPly.setCellValueFactory(new PropertyValueFactory<>("noMatches"));
        colMatchPly.setPrefWidth(115.0);

        table.getColumns().addAll(clubId,colName,colWins,colDraws,colLost,colRg,colSg,colPts,colMatchPly);

        table.setLayoutX(67.0);
        table.setLayoutY(183.0);
        table.setPrefSize(763.0,199.0);

        ObservableList list= FXCollections.observableArrayList();
        list.addAll(lisOfClubs);
        table.setItems(list);

        //creating the second Table and it's columns
        TableView tableTwo = new TableView();

        TableColumn homeName=new TableColumn("Home Team");
        homeName.setCellValueFactory(new PropertyValueFactory<>("teamOneName"));

        TableColumn homeGoals=new TableColumn("Home Goals");
        homeGoals.setCellValueFactory(new PropertyValueFactory<>("teamOneGoalCount"));

        TableColumn awayName=new TableColumn("Away Team");
        awayName.setCellValueFactory(new PropertyValueFactory<>("teamSecName"));

        TableColumn awayGoals=new TableColumn("Away Goals");
        awayGoals.setCellValueFactory(new PropertyValueFactory<>("teamSecGoalCount"));

        TableColumn date=new TableColumn("Date Played");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableTwo.getColumns().addAll(homeName,awayName,homeGoals,awayGoals,date);
        tableTwo.setLayoutX(223.0);
        tableTwo.setLayoutY(403.0);
        tableTwo.setPrefSize(462.0,199.0);

        Label lblHead=new Label(" Premiere League");
        lblHead.setPrefSize(209.0,40.0);
        lblHead.setLayoutX(356);
        lblHead.setLayoutY(36);
        lblHead.setStyle("-fx-background-color: deepskyblue;-fx-font-weight: bold");
        lblHead.setFont(new Font("Lucida Fax",25));

        Button btnWins =new Button("Sort According to Wins");
        btnWins.setLayoutX(506.0);
        btnWins.setLayoutY(133.0);
        btnWins.setStyle("-fx-background-color: lightgreen;-fx-font-weight: bold;-fx-border-color: darkgreen");
        btnWins.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Collections.sort(lisOfClubs, new Comparator<FootballClub>() {
                    @Override
                    public int compare(FootballClub o1, FootballClub o2) {
                        return o1.getNoWins() - o2.getNoWins();
                    }

                }.reversed()); //sorting according to descending order

                //clear and adding newly sorted list
                table.getItems().clear();
                ObservableList list= FXCollections.observableArrayList();
                list.addAll(lisOfClubs);
                table.setItems(list);

            }
        });

        Button btnGoals=new Button("Sort According to Goals");
        btnGoals.setLayoutX(673.0);
        btnGoals.setLayoutY(133.0);
        btnGoals.setStyle("-fx-background-color: lightgreen;-fx-font-weight: bold;-fx-border-color: darkgreen");
        btnGoals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Collections.sort(lisOfClubs, new Comparator<FootballClub>() {
                    @Override
                    public int compare(FootballClub o1, FootballClub o2) {
                        return o1.getScoredGoals() - o2.getScoredGoals();
                    }
                }.reversed()); // for descending

                //clear and adding newly sorted list
                table.getItems().clear();
                ObservableList list = FXCollections.observableArrayList();
                list.addAll(lisOfClubs);
                table.setItems(list);
            }
        });

        Button btnSortDate=new Button("Sort according to Date Played");
        btnSortDate.setLayoutX(500.0);
        btnSortDate.setLayoutY(612.0);
        btnSortDate.setStyle("-fx-background-color: springgreen;-fx-font-weight: bold;-fx-border-color: blue");
        btnSortDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Collections.sort(matchList, new Comparator<Match>() {
                    @Override
                    public int compare(Match d1, Match d2) { //comparing date toString
                        return d1.getDate().toString().compareTo(d2.getDate().toString());
                    }
                });
                //according to ascending order
                tableTwo.getItems().clear();
                ObservableList dateList=FXCollections.observableArrayList();
                dateList.addAll(matchList);
                tableTwo.setItems(dateList);
            }
        });

        Button rndMatch=new Button("Play a Random Match"); //button of playing a random match
        rndMatch.setLayoutX(335.0);
        rndMatch.setLayoutY(612.0);
        rndMatch.setStyle("-fx-background-color: lightblue;-fx-font-weight: bold;-fx-border-color: darkblue");
        rndMatch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Random random = new Random();
                int rdm1;
                int rdm2;
                do {
                    rdm1 = random.nextInt(lisOfClubs.size());
                    rdm2 = random.nextInt(lisOfClubs.size());
                }
                while (rdm1 == rdm2);
                //not to come same teams for the random match
                FootballClub team1 = lisOfClubs.get(rdm1);
                FootballClub team2 = lisOfClubs.get(rdm2);

                //random integers below 25
                int teamOneG = random.nextInt(25);
                int teamTwoG = random.nextInt(25);

                //generating the date
                int year = 2020;
                int month = random.nextInt(12);
                int day = random.nextInt(31);

                Date date = new Date(day, month, year);

                if (teamOneG > teamTwoG) {//team one wins
                    team1.setNoPoints(team1.getNoPoints() + 5); //adding points
                    team1.setNoWins(team1.getNoWins() + 1);
                    team2.setNoDefeats(team2.getNoDefeats() + 1);

                } else if (teamOneG < teamTwoG) {//team two wins
                    team2.setNoPoints(team2.getNoPoints() + 5);
                    team2.setNoWins(team2.getNoWins() + 1);
                    team1.setNoDefeats(team1.getNoDefeats() + 1);

                } else {//when match is drawn
                    team1.setNoPoints(team1.getNoPoints() + 1);
                    team2.setNoPoints(team2.getNoPoints() + 1);
                    team1.setNoDraws(team1.getNoDraws() + 1);
                    team2.setNoDraws(team2.getNoDraws() + 1);
                }

                //passing parameters to the Match Constructor
                Match match = new Match();
                match.setDate(date);
                match.setTeamOneName(team1.getClubName());
                match.setTeamSecName(team2.getClubName());
                match.setTeamOneGoalCount(teamOneG);
                match.setTeamSecGoalCount(teamTwoG);
                matchList.add(match); //adding to the arraylist
                team1.setNoMatches(team1.getNoMatches() + 1);
                team2.setNoMatches(team2.getNoMatches() + 1);

                tableTwo.getItems().clear();
                //adding data for second Table
                ObservableList listTwo = FXCollections.observableArrayList();
                listTwo.addAll(matchList);
                tableTwo.setItems(listTwo);

                }
        });

        TextField txtSearch=new TextField();
        txtSearch.setPromptText("Enter the Date Here");
        txtSearch.setLayoutX(73);
        txtSearch.setLayoutY(133);
        txtSearch.setPrefSize(218.0,25.0);
        txtSearch.setStyle("-fx-background-color: lightblue;-fx-border-color: darkgreen");

        ObservableList listTwo= FXCollections.observableArrayList();
        listTwo.addAll(matchList);
        tableTwo.setItems(listTwo);

        Button btnSearch=new Button("Search");
        btnSearch.setLayoutX(304);
        btnSearch.setLayoutY(126);
        btnSearch.setPrefSize(76.0,40.0);
        btnSearch.setStyle("-fx-background-color: lightgreen;-fx-font-weight: bold;-fx-border-color: darkgreen");

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String search=txtSearch.getText();
                //searching for the date which is entered in TextField
                for (Match match:matchList) {
                    if(match.getDate().toString().equals(search)) {
                        System.out.println(match.getDate().toString());

                        ObservableList listTwo= FXCollections.observableArrayList();
                        listTwo.add(match);
                        tableTwo.setItems(listTwo);

                    }
                } System.out.println("Please enter a Valid Date (YYYY-MM-DD)");
            }
        });

        FileInputStream input = null;
        try {
            input = new FileInputStream("src\\com\\company\\image\\fbimg.jpg");  //adding an Image

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image imgLoan = new Image(input);
        ImageView imageView = new ImageView(imgLoan);
        imageView.setFitHeight(683.0);
        imageView.setFitWidth(896.0);

        AnchorPane anchorPane=new AnchorPane();
        anchorPane.setPrefSize(896.0,683.0);
        anchorPane.setStyle("-fx-background-color: #00bfff");
        anchorPane.getChildren().addAll(imageView,table,lblHead,btnGoals,btnWins,rndMatch,btnSearch,btnSortDate,txtSearch,tableTwo);

        //Setting the scene
        Scene scene = new Scene(anchorPane, 896.0, 683.0);
        stage.setTitle("Football Premiere League");
        stage.setScene(scene);
        stage.show();
    }
}

