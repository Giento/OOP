package hr.fer.oop.MotoGP;

import java.util.*;

public class MethodCalc {

    public static Map<Integer, String> teamRankingCalculation(Map<Integer, Map<Integer, Integer>> standings) {
        Map<Integer, String> teams = new HashMap<>();
        Map<Integer, String> drivers = new HashMap<>();
        Map<Integer, Integer> driverTeamIdentification = new TreeMap<>();

        Map<Integer, String> teamRankings = new TreeMap<>(); //treemap ulazno sortira
        //teamID, TeamPTS
        Map<Integer, Integer> teamStats = new HashMap<>();

        int pts;

        //koliko bodova ima neki vozac u sezoni, tj. zbroj bodova u svim utrkama
        for (int driverID: standings.keySet()) {
            Map<Integer, Integer> raceStats = standings.get(driverID);
            pts = 0;

            //ukupan broj bodova nekog vozaca u svim utrkama
            for (int pointsInRace: raceStats.values())
                pts += pointsInRace;

            //id vozacevog tima
            int teamID = driverTeamIdentification.get(driverID);

            if (teamStats.containsKey(teamID)) {
                int teamPts = teamStats.get(teamID) + pts;
                teamStats.put(teamID, teamPts);
            } else {
                teamStats.put(teamID, pts);
            }
        }

        for(int teamdID : teamStats.keySet()) {
            teamRankings.put(teamStats.get(teamdID), teams.get(teamdID));
        }

        return teamRankings;
    }



}
