package com.soccerleague;

public class Player {
    private String id;
    private String name;
    private int shirtNumber;

    // Constructor
    public Player(String id, String name, int shirtNumber) {
        this.id = id;
        this.name = name;
        this.shirtNumber = shirtNumber;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Override
    public String toString() {
        return name + " (#" + shirtNumber + ")";
    }
}
