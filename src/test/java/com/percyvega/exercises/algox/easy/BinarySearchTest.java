package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    // Time: O(log(n)) time, where n is the number of elements of the array
    // Space: O(1) space
    public static int binarySearch(int[] array, int target) {
        int iLower = 0;
        int iUpper = array.length - 1;

        while(iLower <= iUpper) {
            int iPivot = (iLower + iUpper) / 2;
            int pivotValue = array[iPivot];
            if (pivotValue == target) {
                return iPivot;
            } else if (pivotValue < target) {
                iLower = iPivot + 1;
            } else {
                iUpper = iUpper - 1;
            }
        }

        return -1;
    }

    @Test
    void testBinarySearch() {
        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 7)).isEqualTo(1);
        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 8)).isEqualTo(2);
        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 10)).isEqualTo(3);

        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 6)).isEqualTo(-1);
        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 9)).isEqualTo(-1);
        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 11)).isEqualTo(-1);
        assertThat(binarySearch(new int[] {5, 7, 8, 10, 12}, 13)).isEqualTo(-1);

        assertThat(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33)).isEqualTo(3);
    }

}
