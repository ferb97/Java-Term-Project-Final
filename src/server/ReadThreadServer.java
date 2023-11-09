package server;

import client.Build;
import client.Player;
import client.PlayerList;
import client.PlayerName;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, NetworkUtil> clientMap;

    public ReadThreadServer(HashMap<String, NetworkUtil> map, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof PlayerName) {
                    PlayerName obj = (PlayerName) o;
                    Player p2 = obj.getPlayer();
                    if(obj.getTask().equalsIgnoreCase("Sell")){
                        Server.marketList.add(p2);
                        PlayerList pl1 = new PlayerList(Server.marketList, "marketList");
                        for(String s: Server.clientList){
                            NetworkUtil nu1 = clientMap.get(s);
                            nu1.write(pl1);
                        }
                    }
                    else if(obj.getTask().equalsIgnoreCase("Buy")){
                        for(Player p: Server.playerList){
                            if(p.getName().equalsIgnoreCase(p2.getName())){
                                p.setClub(p2.getClub());
                                break;
                            }
                        }
                        int index = 0;
                        for(Player p: Server.marketList){
                            if(p.getName().equalsIgnoreCase(p2.getName())){
                                break;
                            }
                            index++;
                        }
                        Server.marketList.remove(index);
                        PlayerList pl1 = new PlayerList(Server.marketList, "marketList");
                        for(String s: Server.clientList){
                            NetworkUtil nu1 = clientMap.get(s);
                            nu1.write(pl1);
                            List<Player> playerList1 = new ArrayList();
                            playerList1.addAll(Build.buildUpPlayerList(Server.playerList, s));
                            PlayerList pl2 = new PlayerList(playerList1, "playerList");
                            nu1.write(pl2);
                        }
                    }
                }
                else if(o instanceof String){
                    String clubName = (String) o;
                    int index = 0;
                    for(String s: Server.clientList){
                        if(s.equalsIgnoreCase(clubName)){
                           break;
                        }
                        index++;
                    }
                    Server.clientList.remove(index);
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

