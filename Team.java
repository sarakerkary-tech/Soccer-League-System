package com.soccerleague;

import java.util.ArrayList;

public class Team {
    private String name;

    // Composition: a Team contains a list of Player objects.
    private ArrayList<Player> players;

    private int totalGoals;
    private int points;

    // Constructor
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.totalGoals = 0;
        this.points = 0;
    }

    // Add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public int getPoints() {
        return points;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Useful methods
    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public void addGoals(int goals) {
        totalGoals += goals;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void resetStatistics() {
        totalGoals = 0;
        points = 0;
    }
}
