package com.percyvega.interviewpreparationkit.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MinimumSwaps2 {

    @Test
    void test0() {
        int[] listWithSwaps = new int[] {1, 2, 4, 3};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(1);
    }

    @Test
    void test1() {
        int[] listWithSwaps = new int[] {4, 3, 1, 2};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(3);
    }

    @Test
    void test2() {
        int[] listWithSwaps = new int[] {2, 3, 4, 1, 5};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(3);
    }

    @Test
    void test3() {
        int[] listWithSwaps = new int[] {7, 1, 3, 2, 4, 5, 6};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(5);
    }

    @Test
    void test4() {
        int[] listWithSwaps = new int[] {1, 3, 5, 2, 4, 6, 7};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(3);
    }

    int minimumSwaps(int[] arr) throws IllegalArgumentException {
        int swapCount = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            if(arr[i] != i + 1) {

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == i + 1) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        swapCount++;

                        break;
                    }
                }
            }
        }

        return swapCount;
    }

}
