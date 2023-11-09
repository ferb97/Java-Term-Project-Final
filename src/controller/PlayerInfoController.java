package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import client.Main;
import client.Player;

import java.util.List;

public class PlayerInfoController {

    private Main main;
    
    private ObservableList<Player> playerList;

    private String message;

    private boolean isActive = false;

    @FXML
    private TableView<Player> tableView;

    @FXML
    private Button back;

    @FXML
    private Label label;

    @FXML
    public void Back(ActionEvent event) {
        isActive = false;
        try {
            if(message.equalsIgnoreCase("SearchOption"))
               main.showSearchOption();
            else if(message.equalsIgnoreCase("Menu"))
               main.showMenu();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void initialize(){
        Thread t = new Thread(this::Refresh);
        t.start();
    }

    public void Refresh(){
        while(isActive){
            Platform.runLater(() -> {
                        playersInfo(this.playerList);
                    }
            );
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public void init(String message, String topLabel){

        isActive = true;

        TableColumn<Player, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(170);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Player, String> countryCol = new TableColumn<>("Country");
        countryCol.setMinWidth(80);
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Player, String> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(50);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Player, String> heightCol = new TableColumn<>("Height");
        heightCol.setMinWidth(60);
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Player, String> clubCol = new TableColumn<>("Club");
        clubCol.setMinWidth(120);
        clubCol.setCellValueFactory(new PropertyValueFactory<>("club"));

        TableColumn<Player, String> positionCol = new TableColumn<>("Position");
        positionCol.setMinWidth(93);
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Player, String> numberCol = new TableColumn<>("Number");
        numberCol.setMinWidth(20);
        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Player, String> weeklySalaryCol = new TableColumn<>("Weekly Salary");
        weeklySalaryCol.setMinWidth(40);
        weeklySalaryCol.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));

        tableView.getColumns().addAll(nameCol, countryCol, ageCol, heightCol, clubCol, positionCol, numberCol, weeklySalaryCol);

        this.message = message;

        label.setText(topLabel);
    }

    public void setMain(Main main){
        this.main = main;
        initialize();
    }

    public void playersInfo(List<Player> playerList) {
        this.playerList = FXCollections.observableList(playerList);
        tableView.setEditable(true);
        tableView.setItems(this.playerList);
    }
}
