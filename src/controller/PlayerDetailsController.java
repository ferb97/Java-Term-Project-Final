package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import client.Main;
import client.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class PlayerDetailsController {

    private Main main;

    private String message;

    private Player player;

    @FXML
    private Label playerDetails;

    @FXML
    private Label playerName;

    @FXML
    private Label country;

    @FXML
    private Label age;

    @FXML
    private Label height;

    @FXML
    private Label club;

    @FXML
    private Label position;

    @FXML
    private Label number;

    @FXML
    private Label weeklySalary;

    @FXML
    private Label getPlayerName;

    @FXML
    private Label getCountry;

    @FXML
    private Label getAge;

    @FXML
    private Label getHeight;

    @FXML
    private Label getClub;

    @FXML
    private Label getPosition;

    @FXML
    private Label getNumber;

    @FXML
    private Label getWeeklySalary;

    @FXML
    private Button back;

    @FXML
    private ImageView imageView;

    @FXML
    void Back(ActionEvent event) {
         try{
             if(message.equalsIgnoreCase("Sell")){
                 main.showSellBuyPlayerInfo("Sell");
             }
             else if(message.equalsIgnoreCase("Buy")){
                 main.showSellBuyPlayerInfo("Buy");
             }
         } catch (IOException e) {
             System.out.println(e);;
         }
    }

    public void setMain(Main main){
        this.main = main;
    }

    public void init(Player player, String message){
        this.message = message;
        this.player = player;
        getPlayerName.setText(player.getName());
        getCountry.setText(player.getCountry());
        getAge.setText(player.getAge() + "");
        getHeight.setText(player.getHeight() + "");
        getClub.setText(player.getClub());
        getPosition.setText(player.getPosition());
        getNumber.setText(player.getNumber() + "");
        getWeeklySalary.setText(player.getWeeklySalary() + "");
        Image image = new Image(Main.class.getResourceAsStream("/image/" + player.getName() + ".jpg"));
        imageView.setImage(image);
    }

}
