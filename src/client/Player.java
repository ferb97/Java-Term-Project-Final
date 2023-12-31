package client;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double weeklySalary;

    public Player(){

    }

    public Player(String name, String country, int age, double height, String club, String position, int number, double weeklySalary){
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.club = club;
        this.position = position;
        this.number = number;
        this.weeklySalary = weeklySalary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public void setClub(String club){
        this.club = club;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setWeeklySalary(double weeklySalary){
        this.weeklySalary = weeklySalary;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public int getAge(){
        return age;
    }

    public double getHeight(){
        return height;
    }

    public String getClub(){
        return club;
    }

    public String getPosition(){
        return position;
    }

    public int getNumber(){
        return number;
    }

    public double getWeeklySalary(){
        return weeklySalary;
    }

}
