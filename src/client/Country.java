package client;

public class Country {
    private String name;
    private int playerCount;

    public Country(){
        playerCount = 0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void increasePlayerCount(){
        playerCount++;
    }

    public int getPlayerCount(){
        return playerCount;
    }
}
