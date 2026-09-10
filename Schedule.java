package com.soccerleague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Schedule {

    // Composition: Schedule contains a list of Team objects.
    private ArrayList<Team> teams;

    // Composition: Schedule contains a list of Match objects.
    private ArrayList<Match> matches;

    // Constructor
    public Schedule() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    // Add a team
    public void addTeam(Team team) {
        teams.add(team);
    }

    // Add a match
    public void addMatch(Match match) {
        matches.add(match);
    }

    // Getters
    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    // Setters
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    // Update total goals and points for all teams
    public void updateLeagueStats() {

        // Reset all statistics before recalculation
        for (Team team : teams) {
            team.resetStatistics();
        }

        // Calculate statistics from all matches
        for (Match match : matches) {

            int homeGoals = match.getHomeGoals();
            int awayGoals = match.getAwayGoals();

            // Update total goals
            match.getHomeTeam().addGoals(homeGoals);
            match.getAwayTeam().addGoals(awayGoals);

            // Update points
            if (homeGoals > awayGoals) {

                match.getHomeTeam().addPoints(3);

            } else if (awayGoals > homeGoals) {

                match.getAwayTeam().addPoints(3);

            } else {

                match.getHomeTeam().addPoints(1);
                match.getAwayTeam().addPoints(1);
            }
        }
    }

    // Rank teams by points, then by total goals
    public void rankTeams() {

        updateLeagueStats();

        Collections.sort(teams, new Comparator<Team>() {

            @Override
            public int compare(Team team1, Team team2) {

                // Higher points first
                if (team1.getPoints() != team2.getPoints()) {
                    return Integer.compare(
                        team2.getPoints(),
                        team1.getPoints()
                    );
                }

                // Higher goals first if points are equal
                return Integer.compare(
                    team2.getTotalGoals(),
                    team1.getTotalGoals()
                );
            }
        });
    }

    // Display the league results table
    public void displayResultsTable() {

        rankTeams();

        System.out.println("\n===== SOCCER LEAGUE STANDINGS =====");

        System.out.printf(
            "%-6s %-20s %-10s %-10s%n",
            "Rank",
            "Team",
            "Goals",
            "Points"
        );

        System.out.println("-----------------------------------------------");

        for (int i = 0; i < teams.size(); i++) {

            Team team = teams.get(i);

            System.out.printf(
                "%-6d %-20s %-10d %-10d%n",
                i + 1,
                team.getName(),
                team.getTotalGoals(),
                team.getPoints()
            );
        }

        System.out.println("-----------------------------------------------");
    }

    // Display details of a specific match
    public void displayMatchDetails(String matchId) {

        for (Match match : matches) {

            if (match.getMatchId().equalsIgnoreCase(matchId)) {

                System.out.println(
                    "\n===== MATCH DETAILS ====="
                );

                System.out.println(
                    "Match ID: " + match.getMatchId()
                );

                System.out.println(
                    match.getHomeTeam().getName()
                    + " "
                    + match.getHomeGoals()
                    + " - "
                    + match.getAwayGoals()
                    + " "
                    + match.getAwayTeam().getName()
                );

                System.out.println("\nGoals:");

                if (match.getGoals().isEmpty()) {

                    System.out.println("No goals scored.");

                } else {

                    for (Goal goal : match.getGoals()) {

                        System.out.println(
                            "Minute "
                            + goal.getMinute()
                            + ": "
                            + goal.getScorer().getName()
                            + " (#"
                            + goal.getScorer().getShirtNumber()
                            + ")"
                        );
                    }
                }

                return;
            }
        }

        System.out.println(
            "Match ID " + matchId + " not found."
        );
    }
}
