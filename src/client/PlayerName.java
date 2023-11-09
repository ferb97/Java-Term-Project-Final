package client;

import java.io.Serializable;

public class PlayerName implements Serializable {
    private Player player;
    private String task;

    public PlayerName(Player player, String task){
        this.player = player;
        this.task = task;
    }

    public void setTask(String task){
        this.task = task;
    }

    public void setName(Player player){
        this.player = player;
    }

    public String getTask(){
        return task;
    }

    public Player getPlayer(){
        return player;
    }
}

