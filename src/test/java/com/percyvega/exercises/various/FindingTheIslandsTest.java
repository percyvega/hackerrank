package com.percyvega.exercises.various;

import com.percyvega.model.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Given a matrix of size WxH, find the islands of (areas joined by) 1s, whether vertically, horizontally or diagonally.
 * Look at the test cases for examples.
 */
class FindingTheIslandsTest {

    @Test
    void test0() {
        int[][] matrix = {
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0}};
        List<List<Pair<Integer, Integer>>> islandsOf1s = obtainIslands(matrix);

        assertEquals(5, islandsOf1s.size());
    }

    @Test
    void test1() {
        int[][] matrix = {
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 0, 1}};
        List<List<Pair<Integer, Integer>>> islandsOf1s = obtainIslands(matrix);

        assertEquals(4, islandsOf1s.size());
    }

    private List<List<Pair<Integer, Integer>>> obtainIslands(int[][] matrix) {
        List<List<Pair<Integer, Integer>>> islands = new ArrayList<>();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 1) {
                    List<Pair<Integer, Integer>> island = new ArrayList<>();
                    islands.add(island);

                    visitThisAndSurroundingPoints(matrix, y, x, island);
                }
            }
        }

        return islands;
    }

    private void visitThisAndSurroundingPoints(int[][] matrix, int y, int x, List<Pair<Integer, Integer>> island) {
        if (y < 0 || x < 0 || y >= matrix.length || x >= matrix[y].length) {
            return;
        }

        if (matrix[y][x] == 1) {
            island.add(new Pair<>(y, x));

            matrix[y][x] = -1; // visited!

            // visit clockwise (starting at 12)
            visitThisAndSurroundingPoints(matrix, y - 1, x, island);
            visitThisAndSurroundingPoints(matrix, y - 1, x + 1, island);
            visitThisAndSurroundingPoints(matrix, y, x + 1, island);
            visitThisAndSurroundingPoints(matrix, y + 1, x + 1, island);
            visitThisAndSurroundingPoints(matrix, y + 1, x, island);
            visitThisAndSurroundingPoints(matrix, y + 1, x - 1, island);
            visitThisAndSurroundingPoints(matrix, y, x - 1, island);
            visitThisAndSurroundingPoints(matrix, y - 1, x - 1, island);
        }
    }

}
