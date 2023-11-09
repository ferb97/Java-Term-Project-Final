package client;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;

    private NetworkUtil networkUtil;

    private String clubName;

    public static List<Player> playerList = new ArrayList();

    public static List<Player> marketList = new ArrayList();

    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName){
        this.clubName = clubName;
    }

    public void setNetworkUtil(NetworkUtil networkUtil){
        this.networkUtil = networkUtil;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public FXMLLoader showStage(String fxmlFileName, String title, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFileName));
        Parent root = loader.load();

        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();

        return loader;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        showLogInPage();
    }

    public void showLogInPage() throws Exception{
        LogInController controller = showStage("/fxml/LogIn.fxml", "Log In Page", 675, 421).getController();
        controller.init();
        controller.setMain(this);
    }


    public void showMenu() throws Exception{
        MenuController controller = showStage("/fxml/Menu.fxml", "Menu", 689, 584).getController();
        controller.setMain(this);
        controller.init();
    }

    public void showSearchOption() throws IOException {
        SearchOptionController controller = showStage("/fxml/SearchOption.fxml", clubName, 714, 623).getController();
        controller.setMain(this);
    }

    public void showSearchString(String option) throws IOException {
        SearchStringController controller = showStage("/fxml/SearchString.fxml", clubName, 600, 400).getController();
        controller.init(option);
        controller.setMain(this);
    }

    public void showPlayerInfo(List<Player> playerList, String message, String topLabel) throws IOException {
        PlayerInfoController controller = showStage("/fxml/PlayerInfo.fxml", clubName, 860, 594).getController();
        controller.init(message, topLabel);
        controller.setMain(this);
        controller.playersInfo(playerList);
    }

    public void showResult(String message) throws IOException {
        ShowResultController controller = showStage("/fxml/showResult.fxml", clubName, 781, 223).getController();
        controller.init(message);
        controller.setMain(this);
    }

    public void showSearchBySalaryRange() throws IOException {
        SearchBySalaryRangeController controller = showStage("/fxml/SearchBySalaryRange.fxml", clubName, 600, 426).getController();
        controller.init();
        controller.setMain(this);
    }

    public void showCountrywisePlayerCount() throws Exception{
        CountrywisePlayerCountController controller = showStage("/fxml/CountrywisePlayerCount.fxml", clubName, 460, 609).getController();
        controller.init();
        controller.setMain(this);
        controller.showTable();
    }

    public void showSellBuyPlayerInfo(String message) throws IOException {
        SellBuyPlayerInfoController controller = showStage("/fxml/SellBuyPlayerInfo.fxml", clubName, 600, 650).getController();
        controller.init(message);
        controller.setMain(this);
        controller.showTable();
    }

    public void showPlayerDetails(Player p, String message) throws IOException {
        PlayerDetailsController controller = showStage("/fxml/PlayerDetails.fxml", clubName, 701, 506).getController();
        controller.init(p, message);
        controller.setMain(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
