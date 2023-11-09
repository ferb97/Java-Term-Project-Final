package client;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public static Player searchByPlayerName(List<Player> playerList, String s){
        Player p1 = new Player();
        for(Player p: playerList){
            if(p.getName().equalsIgnoreCase(s)){
                p1 = p;
                break;
            }
        }
        return p1;
    }

    public static List<Player> searchByCountry(List<Player> playerList, String country_name){
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(p.getCountry().equalsIgnoreCase(country_name)){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> searchByPosition(List<Player> playerList, String position){
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(p.getPosition().equalsIgnoreCase(position)){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> searchBySalaryRange(List<Player> playerList, Double lower_bound, Double upper_bound){
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(lower_bound <= p.getWeeklySalary() && p.getWeeklySalary() <= upper_bound){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> playersWithTheMaximumSalary(List<Player> playerList){
        double max_salary = 0;
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(p.getWeeklySalary() > max_salary){
                max_salary = p.getWeeklySalary();
            }
        }
        for(Player p: playerList){
            if(p.getWeeklySalary() == max_salary){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> playersWithTheMaximumAge(List<Player> playerList){
        int max_age = 0;
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(p.getAge() > max_age){
                max_age = p.getAge();
            }
        }
        for(Player p: playerList){
            if(p.getAge() == max_age){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static List<Player> playersWithTheMaximumHeight(List<Player> playerList){
        double max_height = 0;
        List<Player> playerList1 = new ArrayList();
        for(Player p: playerList){
            if(p.getHeight() > max_height){
                max_height = p.getHeight();
            }
        }
        for(Player p: playerList){
            if(p.getHeight() == max_height){
                playerList1.add(p);
            }
        }
        return playerList1;
    }

    public static String totalYearlySalary(List<Player> playerList){
        double totalSalary = 0;
        for(Player p: playerList){
            totalSalary = totalSalary + p.getWeeklySalary() * 52;
        }
        String s = String.format("%f",totalSalary);
        return s;
    }

    public static boolean isClubPresent(List<Player> playerList, String clubName){
        for(Player p: playerList){
            if(clubName.equalsIgnoreCase(p.getClub())){
               return true;
            }
        }
        return false;
    }
}
