package com.percyvega.exercises.interviewpreparationkit.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MinimumSwaps {

    @Test
    void test1() {
        int[] listWithSwaps = new int[]{2, 1, 5, 3, 4};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(3);
    }

    @Test
    void test2() {
        int[] listWithSwaps = new int[]{2, 1, 5, 4, 3};
        assertThat(minimumSwaps(listWithSwaps)).isEqualTo(4);
    }

    @Test
    void test3() {
        int[] listWithSwaps = new int[]{2, 5, 1, 4, 3};
        assertThatThrownBy(() -> minimumSwaps(listWithSwaps)).isInstanceOf(IllegalArgumentException.class);
    }

    int minimumSwaps(int[] listWithSwaps) throws IllegalArgumentException {
        for (int i = 0; i < listWithSwaps.length; i++) {
            if (listWithSwaps[i] - i > 3) {
                throw new IllegalArgumentException(listWithSwaps[i] + " can not move more than twice from its original place");
            }
        }

        int swapCount = 0;
        for (int i = 1; i < listWithSwaps.length; i++) {
            for (int j = 0; j < listWithSwaps.length - i; j++) {
                if (listWithSwaps[j] > listWithSwaps[j + 1]) {
                    int temp = listWithSwaps[j];
                    listWithSwaps[j] = listWithSwaps[j + 1];
                    listWithSwaps[j + 1] = temp;

                    swapCount++;
                }
            }
        }

        return swapCount;
    }

}
