package com.percyvega.exercises.various;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestPositiveIntegerNotFoundInArray {

    @Test
    void testSmallestPositiveIntegerNotFoundInArray() {
        assertThat(getSmallestInt(new int[]{10})).isEqualTo(1);
        assertThat(getSmallestInt(new int[]{1, 3, 6, 4, 1, 2})).isEqualTo(5);
        assertThat(getSmallestInt(new int[]{1, 2, 3})).isEqualTo(4);
        assertThat(getSmallestInt(new int[]{-1, -3})).isEqualTo(1);
    }

    private int getSmallestInt(int[] A) {
        Arrays.sort(A);
        int i = 0;
        while (true) {
            if (Arrays.binarySearch(A, ++i) < 0) {
                return i;
            }
        }
    }

}
