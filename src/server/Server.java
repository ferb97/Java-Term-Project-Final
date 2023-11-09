package server;

import client.*;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;

    private HashMap<String, NetworkUtil> clientMap;

    public static List<Player> playerList;

    public static List<Player> marketList = new ArrayList();

    public static List<String> clientList = new ArrayList();

    Server() {
        clientMap = new HashMap<>();
        try{
            playerList = new ArrayList();
            playerList.addAll(FileOperation.readFromFile());
            serverSocket = new ServerSocket(44444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clubName = (String) networkUtil.read();
        boolean b = false;
        for(Player p: playerList){
            if(p.getClub().equalsIgnoreCase(clubName)){
               b = true;
               break;
            }
        }
        if(!b){
           String s = "No such club with this name";
           networkUtil.write(s);
           return;
        }
        b = true;
        for(String s: clientList){
           if(s.equalsIgnoreCase(clubName)){
              b = false;
              break;
           }
        }
        if(!b){
           String s = clubName + " is already logged in";
           networkUtil.write(s);
           return;
        }
        else {
            String s = "Login Successful";
            networkUtil.write(s);
            List<Player> playerList1 = new ArrayList();
            playerList1.addAll(Build.buildUpPlayerList(playerList, clubName));
            PlayerList pl1 = new PlayerList(playerList1, "playerList");
            networkUtil.write(pl1);
            List<Player> marketList1 = new ArrayList();
            marketList1.addAll(marketList);
            PlayerList ml1 = new PlayerList(marketList1, "marketList");
            networkUtil.write(ml1);
            clientList.add(clubName);
            clientMap.put(clubName, networkUtil);
            new ReadThreadServer(clientMap, networkUtil);
        }
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}

