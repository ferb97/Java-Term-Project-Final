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
import client.Main;
import client.Player;
import client.PlayerExchange;

import java.util.ArrayList;
import java.util.List;

public class SellBuyPlayerInfoController {

    private Main main;

    private ObservableList<PlayerExchange> playerExchangeList;

    private String message;

    private boolean isActive = false;

    @FXML
    private Label sellBuyPlayer;

    @FXML
    private TableView<PlayerExchange> tableView;

    @FXML
    private Button back;

    @FXML
    void Back(ActionEvent event) {
        isActive = false;
        try{
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

    public void setMain(Main main){
        this.main = main;
        initialize();
    }

    public void init(String message){

        isActive = true;
        this.message = message;

        sellBuyPlayer.setText(message + " Player");

        TableColumn<PlayerExchange, String> playerNameCol = new TableColumn<>("Player Name");
        playerNameCol.setMinWidth(300);
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<PlayerExchange, Button> sellBuyCol = new TableColumn<>("Action");
        sellBuyCol.setMinWidth(60);
        sellBuyCol.setCellValueFactory(new PropertyValueFactory<>("sellBuy"));

        TableColumn<PlayerExchange, Button> detailsCol = new TableColumn<>("Details");
        detailsCol.setMinWidth(80);
        detailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));

        tableView.getColumns().addAll(playerNameCol, sellBuyCol, detailsCol);

    }

    public void showTable() {
        List<Player> playerList1 = new ArrayList();
        List<PlayerExchange> playerExchangeList = new ArrayList();
        if(message.equalsIgnoreCase("Sell")){
            playerList1.addAll(Build.buildUpSellList(Main.playerList, Main.marketList));
            for(Player p1: playerList1){
                playerExchangeList.add(new PlayerExchange(p1.getName(), "Sell", this.main));
            }
        }
        else if(message.equalsIgnoreCase("Buy")){
            playerList1.addAll(Build.buildUpMarketList(Main.marketList, this.main.getClubName()));
            for(Player p1: playerList1){
                playerExchangeList.add(new PlayerExchange(p1.getName(), "Buy", this.main));
            }
        }
        this.playerExchangeList = FXCollections.observableList(playerExchangeList);
        tableView.setEditable(true);
        tableView.setItems(this.playerExchangeList);
    }
}
