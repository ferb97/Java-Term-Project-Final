package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import client.Main;

public class ShowResultController {

    private Main main;

    private String message;

    @FXML
    Label label;

    @FXML
    private Button back;

    public void init(String message){
        label.setText(message);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void Back(ActionEvent event) {
        try {
            main.showSearchOption();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
