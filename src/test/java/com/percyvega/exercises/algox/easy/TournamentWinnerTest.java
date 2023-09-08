package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TournamentWinnerTest {

    // O(n) time | O(k) space - where n is the number of competitions, and k is the number of teams
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> trackScores = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            String winner = competitions.get(i).get(results.get(i) == 1 ? 0 : 1);
            Integer totalScore = trackScores.get(winner);
            if (totalScore == null) {
                trackScores.put(winner, 3);
            } else {
                trackScores.put(winner, totalScore + 3);
            }
        }

        Map.Entry<String, Integer> winner = trackScores.entrySet().stream().max((o1, o2) -> o1.getValue() - o2.getValue()).get();

        return winner.getKey();
    }

    @Test
    void testTournamentWinner() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>(List.of(
                new ArrayList<>(List.of("HTML", "C#")),
                new ArrayList<>(List.of("C#", "Python")),
                new ArrayList<>(List.of("Python", "HTML"))
        ));
        ArrayList<Integer> results = new ArrayList<>(List.of(0, 0, 1));

        assertThat(tournamentWinner(competitions, results)).isEqualTo("Python");
    }

}
