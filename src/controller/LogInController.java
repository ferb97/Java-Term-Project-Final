package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import client.Main;
import client.ReadThreadClient;
import util.NetworkUtil;

import static java.lang.System.exit;

public class LogInController {

    private Main main;

    @FXML
    private Button logInButton;

    @FXML
    private TextField clubNameText;

    @FXML
    private Label enterClubName;

    @FXML
    private Button reset;

    @FXML
    private Button exit;

    @FXML
    private ImageView imageView;

    @FXML
    void Exit(ActionEvent event) {
        exit(0);
    }

    @FXML
    void LogIn(ActionEvent event) {
        String clubName = clubNameText.getText();
        String serverAddress = "127.0.0.1";
        int serverPort = 44444;
        try {
            main.setClubName(clubName);
            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);
            main.setNetworkUtil(networkUtil);
            networkUtil.write(clubName);
            String s = (String) networkUtil.read();
            if(s.equalsIgnoreCase("Login Successful")) {
                new ReadThreadClient(networkUtil, clubName);
                main.showMenu();
            }
            else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Invalid Log In");
                a.setContentText(s);
                a.showAndWait();
                clubNameText.setText(null);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void Reset(ActionEvent event) {
        clubNameText.setText(null);
    }

    public void init(){
        Image image = new Image(Main.class.getResourceAsStream("/image/1.png"));
        imageView.setImage(image);
    }

    public void setMain(Main main){
        this.main = main;
    }

}
