package com.soccerleague;

import java.util.ArrayList;

public class Match {
    private String matchId;

    // Association: a Match has a home Team and an away Team.
    private Team homeTeam;
    private Team awayTeam;

    // Composition: a Match contains a list of Goal objects.
    private ArrayList<Goal> goals;

    // Constructor
    public Match(String matchId, Team homeTeam, Team awayTeam) {
        this.matchId = matchId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.goals = new ArrayList<>();
    }

    // Add a goal to the match
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    // Getters
    public String getMatchId() {
        return matchId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    // Setters
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
    }

    // Calculate home team goals
    public int getHomeGoals() {
        int count = 0;

        for (Goal goal : goals) {
            if (homeTeam.hasPlayer(goal.getScorer())) {
                count++;
            }
        }

        return count;
    }

    // Calculate away team goals
    public int getAwayGoals() {
        int count = 0;

        for (Goal goal : goals) {
            if (awayTeam.hasPlayer(goal.getScorer())) {
                count++;
            }
        }

        return count;
    }
}
