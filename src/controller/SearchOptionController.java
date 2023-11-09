package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import client.Main;
import client.Player;
import client.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchOptionController {

    private Main main;

    @FXML
    private Label searchOptions;

    @FXML
    private Button byPlayerName;

    @FXML
    private Button byCountry;

    @FXML
    private Button byPosition;

    @FXML
    private Button bySalaryRange;

    @FXML
    private Button countrywisePlayerCount;

    @FXML
    private Button maximumSalary;

    @FXML
    private Button maximumAge;

    @FXML
    private Button maximumHeight;

    @FXML
    private Button totalYearlySalary;

    @FXML
    private Button backToMainMenu;

    @FXML
    void BackToMainMenu(ActionEvent event) {
        try{
           main.showMenu();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void ByCountry(ActionEvent event) {
        try{
            main.showSearchString("Country");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void ByPlayerName(ActionEvent event) {
         try{
             main.showSearchString("Player Name");
         }
         catch(Exception e){
             System.out.println(e);
         }
    }

    @FXML
    void ByPosition(ActionEvent event) {
        try{
            main.showSearchString("Position");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void BySalaryRange(ActionEvent event) {
        try{
            main.showSearchBySalaryRange();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void CountrywisePlayerCount(ActionEvent event) {
        try{
            main.showCountrywisePlayerCount();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void MaximumAge(ActionEvent event) throws IOException {
        List<Player> playerList1 = new ArrayList();
        playerList1.addAll(Search.playersWithTheMaximumAge(Main.playerList));
        main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
    }

    @FXML
    void MaximumHeight(ActionEvent event) throws IOException{
        List<Player> playerList1 = new ArrayList();
        playerList1.addAll(Search.playersWithTheMaximumHeight(Main.playerList));
        main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
    }

    @FXML
    void MaximumSalary(ActionEvent event) throws IOException{
        List<Player> playerList1 = new ArrayList();
        playerList1.addAll(Search.playersWithTheMaximumSalary(Main.playerList));
        main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
    }

    @FXML
    void TotalYearlySalary(ActionEvent event) throws IOException {
        main.showResult("Total Yearly Salary of " + main.getClubName() + " = " + Search.totalYearlySalary(Main.playerList));
    }

    public void setMain(Main main){
        this.main = main;
    }


}
