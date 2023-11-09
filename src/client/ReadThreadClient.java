package client;

import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    private String clubName;

    public ReadThreadClient(NetworkUtil networkUtil, String clubName) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        this.clubName = clubName;
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof PlayerList) {
                    PlayerList obj = (PlayerList) o;
                    List<Player> playerList1 = new ArrayList();
                    playerList1.addAll(obj.getPlayerList());
                    if(obj.getTask().equalsIgnoreCase("playerList")){
                        Main.playerList.clear();
                        Main.playerList.addAll(playerList1);
                    }
                    else{
                        Main.marketList.clear();
                        Main.marketList.addAll(playerList1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

