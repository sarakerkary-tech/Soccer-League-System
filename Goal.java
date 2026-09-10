package com.soccerleague;

public class Goal {
    private String matchId;

    // Association: a Goal references the Player who scored.
    private Player scorer;

    private int minute;

    // Constructor
    public Goal(String matchId, Player scorer, int minute) {
        this.matchId = matchId;
        this.scorer = scorer;
        this.minute = minute;
    }

    // Getters
    public String getMatchId() {
        return matchId;
    }

    public Player getScorer() {
        return scorer;
    }

    public int getMinute() {
        return minute;
    }

    // Setters
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public void setScorer(Player scorer) {
        this.scorer = scorer;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
