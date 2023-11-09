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
import client.Build;
import client.Country;
import client.Main;

import java.util.List;

public class CountrywisePlayerCountController {

    private Main main;

    private ObservableList<Country> countryList;

    private boolean isActive = false;

    @FXML
    private Label countrywisePlayerCount;

    @FXML
    private TableView<Country> tableView;

    @FXML
    private Button back;

    @FXML
    void Back(ActionEvent event) {
        isActive = false;
        try {
            main.showSearchOption();
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
                        showTable();
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

    public void init(){
        isActive = true;

        TableColumn<Country, String> nameCol = new TableColumn<>("Country");
        nameCol.setMinWidth(160);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Country, String> playerCountCol = new TableColumn<>("Player Count");
        playerCountCol.setMinWidth(160);
        playerCountCol.setCellValueFactory(new PropertyValueFactory<>("playerCount"));

        tableView.getColumns().addAll(nameCol, playerCountCol);

    }

    public void setMain(Main main) {
        this.main = main;
        initialize();
    }

    public void showTable() {
        List<Country> countryList = Build.buildUpCountryList(Main.playerList);
        this.countryList = FXCollections.observableList(countryList);
        tableView.setEditable(true);
        tableView.setItems(this.countryList);
    }
}
