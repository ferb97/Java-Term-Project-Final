package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import client.Main;
import client.Player;
import client.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStringController {

    private Main main;

    private String option;

    @FXML
    private Label searchOption;

    @FXML
    private Label enterOption;

    @FXML
    private TextField enterOptionText;

    @FXML
    private Button reset;

    @FXML
    private Button search;

    @FXML
    private Button back;

    @FXML
    void Back(ActionEvent event) {
        try{
            main.showSearchOption();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void Reset(ActionEvent event) {
        enterOptionText.setText(null);
    }

    @FXML
    void Search(ActionEvent event) throws IOException {
        if(option.equalsIgnoreCase("Player Name")) {
            String playerName = enterOptionText.getText();
            Player p = Search.searchByPlayerName(Main.playerList, playerName);
            if(p.getName() != null){
                List<Player> playerList1 = new ArrayList();
                playerList1.add(p);
                main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
            }
            else{
                main.showResult("No such player with this name");
            }
        }
        else if(option.equalsIgnoreCase("Country")){
            String country = enterOptionText.getText();
            List<Player> playerList1 = new ArrayList();
            playerList1.addAll(Search.searchByCountry(Main.playerList, country));
            if(playerList1.size() > 0){
                main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
            }
            else{
                main.showResult("No such player with this country");
            }
        }
        else if(option.equalsIgnoreCase("Position")){
            String position = enterOptionText.getText();
            List<Player> playerList1 = new ArrayList();
            playerList1.addAll(Search.searchByPosition(Main.playerList, position));
            if(playerList1.size() > 0){
                main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
            }
            else{
                main.showResult("No such player with this position");
            }
        }
    }

    public void setMain(Main main){
        this.main = main;
    }

    public void init(String option){
        this.option = option;
        enterOptionText.setText(null);
        enterOption.setText("Enter " + option + ": ");
        searchOption.setText("Search by " + option);
    }

}
