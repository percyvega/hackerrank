package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedSquaredArrayTest {

    // O(n log(n)) time | O(n) space - where n is the length of the input array
    public int[] sortedSquaredArray1(int[] array) {
        int[] sortedSquared = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sortedSquared[i] = array[i] * array[i];
        }

        Arrays.sort(sortedSquared);

        return sortedSquared;
    }

    // O(n) time | O(n) space - where n is the length o the input array
    public int[] sortedSquaredArray2(int[] array) {
        int[] sortedSquared = new int[array.length];

        int arrayLowIdx = 0;
        int arrayHighIdx = array.length - 1;

        int sortedHighIdx = array.length - 1;

        while (sortedHighIdx > 0) {
            if (Math.abs(array[arrayLowIdx]) > Math.abs(array[arrayHighIdx])) {
                sortedSquared[sortedHighIdx] = array[arrayLowIdx] * array[arrayLowIdx];
                arrayLowIdx++;
            } else {
                sortedSquared[sortedHighIdx] = array[arrayHighIdx] * array[arrayHighIdx];
                arrayHighIdx--;
            }
            sortedHighIdx--;
        }

        sortedSquared[sortedHighIdx] = array[arrayLowIdx] * array[arrayLowIdx];

        return sortedSquared;
    }

    @Test
    void testSortedSquaredArray() {
        int[] array = new int[]{-6, 1, 2, 3, 5, 8, 9};
        int[] expected = new int[]{1, 4, 9, 25, 36, 64, 81};

        assertThat(sortedSquaredArray1(array)).isEqualTo(expected);
        assertThat(sortedSquaredArray2(array)).isEqualTo(expected);

        array = new int[]{-20, -16, -3, 2, 4, 10};
        expected = new int[]{4, 9, 16, 100, 256, 400};

        assertThat(sortedSquaredArray1(array)).isEqualTo(expected);
        assertThat(sortedSquaredArray2(array)).isEqualTo(expected);
    }

}
