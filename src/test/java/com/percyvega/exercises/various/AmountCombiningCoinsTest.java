package com.percyvega.exercises.various;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn't matter.
 * For example:
 *      When N = 4 and S = {3,1,2}, there are 4 solutions: {1,3}, {1,1,1,1}, {1,1,2}, and {2,2}.
 *      When N = 10 and S = {2, 5, 3, 6}, there are 5 solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5}, and {5,5}.
 */
class AmountCombiningCoinsTest {

    @Test
    void test0() {
        int totalAmount = 4;
        List<Integer> coinSet = Arrays.asList(3, 1, 2);
        List<List<Integer>> solutions = new ArrayList<>();
        calculateCombinations(totalAmount, coinSet, new ArrayList<>(), solutions);

        assertEquals(4, solutions.size());
    }

    @Test
    void test1() {
        int totalAmount = 10;
        List<Integer> coinSet = Arrays.asList(2, 5, 3, 6);
        List<List<Integer>> solutions = new ArrayList<>();
        calculateCombinations(totalAmount, coinSet, new ArrayList<>(), solutions);

        assertEquals(5, solutions.size());
    }

    private static void calculateCombinations(int totalAmount, List<Integer> coinSet, List<Integer> listSoFar, List<List<Integer>> solutions) {
        if (totalAmount == 0) {
            solutions.add(listSoFar);
        } else if (totalAmount > 0) {
            for (Integer coinValue : coinSet) {
                List<Integer> newCoinSet = coinSet.stream().filter(iCoinValue -> iCoinValue >= coinValue).collect(Collectors.toList());

                ArrayList<Integer> newListSoFar = new ArrayList<>(listSoFar);
                newListSoFar.add(coinValue);

                calculateCombinations(totalAmount - coinValue, newCoinSet, newListSoFar, solutions);
            }
        }
    }
}
