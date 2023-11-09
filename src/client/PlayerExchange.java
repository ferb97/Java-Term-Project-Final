package client;

import javafx.scene.control.Button;

import java.io.IOException;

public class PlayerExchange {

    private Main main;

    private String playerName;

    private Button sellBuy;

    private Button details;

    public PlayerExchange(String playerName, String message, Main main) {
        this.main = main;
        this.playerName = playerName;
        sellBuy = new Button(message);
        details = new Button("Details");

        sellBuy.setOnAction(e -> {
                    if (sellBuy.getText().equalsIgnoreCase("Sell")) {
                        Player p = Search.searchByPlayerName(Main.playerList, this.playerName);
                        try {
                            this.main.getNetworkUtil().write(new PlayerName(p, "Sell"));
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else if (sellBuy.getText().equalsIgnoreCase("Buy")) {
                        Player p = Search.searchByPlayerName(Main.marketList, this.playerName);
                        p.setClub(this.main.getClubName());
                        try {
                            this.main.getNetworkUtil().write(new PlayerName(p, "Buy"));
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
        );

        details.setOnAction(e -> {
                    if (sellBuy.getText().equalsIgnoreCase("Sell")) {
                        Player p = Search.searchByPlayerName(Main.playerList, this.playerName);
                        try {
                            this.main.showPlayerDetails(p, "Sell");
                        } catch (IOException ioException) {
                            System.out.println(ioException);
                        }

                    }
                    else if (sellBuy.getText().equalsIgnoreCase("Buy")) {
                        Player p = Search.searchByPlayerName(Main.marketList, this.playerName);
                        try {
                            this.main.showPlayerDetails(p, "Buy");
                        } catch (IOException ioException) {
                            System.out.println(ioException);
                        }

                    }
                }
        );
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setSellBuy(Button sellBuy) {
        this.sellBuy = sellBuy;
    }

    public void setDetails(Button details) {
        this.details = details;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Button getSellBuy() {
        return sellBuy;
    }

    public Button getDetails() {
        return details;
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
