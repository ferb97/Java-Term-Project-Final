package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import client.Main;
import client.Player;
import client.Search;

import java.io.IOException;
import java.util.List;

public class SearchBySalaryRangeController {

    private Main main;

    @FXML
    private Label searchBySalaryRange;

    @FXML
    private Label enterLowerBoundOfSalary;

    @FXML
    private Label enterUpperBoundOfSalary;

    @FXML
    private TextField lowerBoundOfSalaryText;

    @FXML
    private TextField upperBoundOfSalaryText;

    @FXML
    private Button reset;

    @FXML
    private Button search;

    @FXML
    private Button back;

    @FXML
    void Back(ActionEvent event) {
        try {
            main.showSearchOption();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void Reset(ActionEvent event) {
        upperBoundOfSalaryText.setText(null);
        lowerBoundOfSalaryText.setText(null);
    }

    @FXML
    void Search(ActionEvent event) throws IOException {
        double lowerBound = 0;
        double upperBound = 0;
        boolean isDouble = false;
            try{
               lowerBound = Double.parseDouble(lowerBoundOfSalaryText.getText());
               upperBound = Double.parseDouble(upperBoundOfSalaryText.getText());
               isDouble = true;
            }
            catch(Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Invalid Input");
                a.setContentText("Input type not double");
                a.showAndWait();
            }
        if(!isDouble){
            main.showSearchBySalaryRange();
        }
        else {
            List<Player> playerList1 = Search.searchBySalaryRange(Main.playerList, lowerBound, upperBound);
            if (playerList1.size() > 0) {
                main.showPlayerInfo(playerList1, "SearchOption", "Player Info");
            } else {
                main.showResult("No such player with this weekly salary range");
            }
        }
    }

    public void init(){
        upperBoundOfSalaryText.setText(null);
        lowerBoundOfSalaryText.setText(null);
    }

    public void setMain(Main main){
        this.main = main;
    }

}
