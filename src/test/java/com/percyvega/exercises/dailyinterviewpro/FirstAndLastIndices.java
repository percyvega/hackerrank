package com.percyvega.exercises.dailyinterviewpro;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstAndLastIndices {

    @Test
    void isValidTest() {
        assertThat(getFirstAndLast(new int[]{1, 3, 3, 5, 7, 8, 9, 9, 9, 15}, 9)).containsExactly(6, 8);
        assertThat(getFirstAndLast(new int[]{100, 150, 150, 153}, 150)).containsExactly(1, 2);
        assertThat(getFirstAndLast(new int[]{1, 2, 3, 4, 5, 6, 10}, 9)).containsExactly(-1, -1);
    }

    private int[] getFirstAndLast(int[] ints, int target) {
        int[] firstAndLastIndices = new int[]{-1, -1};

        boolean foundFirst = false;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == target) {
                if (foundFirst) {
                    firstAndLastIndices[1] = i;
                } else {
                    foundFirst = true;
                    firstAndLastIndices[0] = i;
                }
            }
        }

        return firstAndLastIndices;
    }

}
