package client;

import java.util.ArrayList;
import java.util.List;

public class Build {

    public static List<Country> buildUpCountryList(List<Player> playerList){
        List<Country> countryList = new ArrayList();
        for(Player p: playerList){
            boolean b = false;
            for(int i = 0; i < countryList.size(); i++){
                Country c = countryList.get(i);
                if(c.getName().equalsIgnoreCase(p.getCountry())){
                    b = true;
                    c.increasePlayerCount();
                    break;
                }
            }
            if(!b){
                Country c = new Country();
                c.setName(p.getCountry());
                c.increasePlayerCount();
                countryList.add(c);
            }
        }
        return countryList;
    }

    public static List<Player> buildUpPlayerList(List<Player> playerList, String clubName){
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(clubName.equalsIgnoreCase(p.getClub())){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> buildUpMarketList(List<Player> marketList, String clubName){
        List<Player> marketList1 = new ArrayList();
        for(Player p: marketList){
            if(!clubName.equalsIgnoreCase(p.getClub())){
                marketList1.add(p);
            }
        }
        return marketList1;
    }

    public static List<Player> buildUpSellList(List<Player> playerList, List<Player> marketList){
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            boolean b = true;
            for(Player p1: marketList){
                if(p.getName().equalsIgnoreCase(p1.getName())){
                    b = false;
                    break;
                }
            }
            if(b){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> buildUpBuyList(List<Player> marketList, String clubName){
        List<Player> marketList1 = new ArrayList();
        for(Player p: marketList){
            if(!p.getClub().equalsIgnoreCase(clubName)){
                marketList1.add(p);
            }
        }
        return marketList1;
    }

}
