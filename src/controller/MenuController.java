package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import client.Build;
import client.Main;
import client.Player;
import client.PlayerExchange;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class MenuController {

    private Main main;

    @FXML
    private Label menu;

    @FXML
    private Button showPlayerList;

    @FXML
    private Button search;

    @FXML
    private Button exitSystem;

    @FXML
    private Button showMarketList;

    @FXML
    private Button sellPlayer;

    @FXML
    private Button buyPlayer;

    @FXML
    private ImageView imageView;

    @FXML
    void BuyPlayer(ActionEvent event) throws IOException {
        List<Player> marketList1 = new ArrayList();
        marketList1.addAll(Build.buildUpMarketList(Main.marketList, main.getClubName()));
        List<PlayerExchange> playerExchangeList = new ArrayList();
        for(Player p: marketList1){
            playerExchangeList.add(new PlayerExchange(p.getName(), "Buy", main));
        }
        main.showSellBuyPlayerInfo("Buy");
    }

    @FXML
    void ExitSystem(ActionEvent event) throws IOException {
        main.getNetworkUtil().write(main.getClubName());
        exit(0);
    }

    @FXML
    void Search(ActionEvent event) {
        try{
            main.showSearchOption();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void SellPlayer(ActionEvent event) throws IOException {
        List<Player> playerList1 = new ArrayList();
        playerList1.addAll(Build.buildUpSellList(Main.playerList, Main.marketList));
        List<PlayerExchange> playerExchangeList = new ArrayList();
        for(Player p: playerList1){
            playerExchangeList.add(new PlayerExchange(p.getName(), "Sell", main));
        }
        main.showSellBuyPlayerInfo("Sell");
    }

    @FXML
    void ShowMarketList(ActionEvent event) {
        try{
            main.showPlayerInfo(Main.marketList, "Menu", "Market List");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void showPlayerList(ActionEvent event) {
        try{
            main.showPlayerInfo(Main.playerList, "Menu", "Player List");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void setMain(Main main){
        this.main = main;
    }

    public void init(){

        if(main.getClubName().equalsIgnoreCase("Liverpool")) {
            Image image = new Image(Main.class.getResourceAsStream("/image/Liverpool.jpg"));
            imageView.setImage(image);
        }
        else if(main.getClubName().equalsIgnoreCase("Chelsea")) {
            Image image = new Image(Main.class.getResourceAsStream("/image/Chelsea.jpg"));
            imageView.setImage(image);
        }
        else if(main.getClubName().equalsIgnoreCase("Arsenal")) {
            Image image = new Image(Main.class.getResourceAsStream("/image/Arsenal.jpg"));
            imageView.setImage(image);
        }
        else if(main.getClubName().equalsIgnoreCase("Manchester City")) {
            Image image = new Image(Main.class.getResourceAsStream("/image/Manchester City.jpg"));
            imageView.setImage(image);
        }
        else if(main.getClubName().equalsIgnoreCase("Manchester United")) {
            Image image = new Image(Main.class.getResourceAsStream("/image/Manchester United.jpg"));
            imageView.setImage(image);
        }
    }

}
