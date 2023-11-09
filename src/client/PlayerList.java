package client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerList implements Serializable {
    private List<Player> playerList = new ArrayList();

    private String task;

    public PlayerList(List<Player> playerList, String task){
        this.playerList.clear();
        this.playerList.addAll(playerList);
        this.task = task;
    }

    public void setTask(String task){
        this.task = task;
    }

    public void setList(List<Player> playerList){
        this.playerList = playerList;
    }

    public String getTask(){
        return task;
    }

    public List<Player> getPlayerList(){
        return playerList;
    }
}

