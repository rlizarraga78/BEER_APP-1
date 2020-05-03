package com.example.beer_app;

import java.util.ArrayList;

public class User {

    String userId;
    String username;
    String beersMade;
    String beersInMaking;

    public User() {

    }

    public User(String userId, String userName){
        this.userId = userId;
        this.username = userName;
        this.beersMade = "None";
        this.beersInMaking = "None";
    }

    public User(String userId, String userName, String beersMade, String beersInMaking){
        this.userId = userId;
        this.username = userName;
        this.beersMade = beersMade;
        this.beersInMaking = beersInMaking;
    }

    public String getUserId(){
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getBeersInMaking() {
        return beersInMaking;
    }

    public String getBeersMade() {
        return beersMade;
    }

}
