package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class FindPythagoreanTriplets {

    @Test
    void testThis() {
        assertThat(findTriplets(3, 5, 12, 5, 13)).isTrue();
        assertThat(findTriplets(6, 8, 10)).isTrue();
        assertThat(findTriplets(3, 4, 5)).isTrue();
        assertThat(findTriplets(5, 12, 13)).isTrue();

        assertThat(findTriplets(4, 7, 1, 3, 2)).isFalse();
        assertThat(findTriplets(4, 1, 3, 2)).isFalse();
        assertThat(findTriplets(7, 1, 2, 9)).isFalse();
        assertThat(findTriplets(2, 1, 3, 5)).isFalse();
    }

    private boolean findTriplets(int... ints) {
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                double c = getCFromAAndB(ints[i], ints[j]);
                for (int k = 0; k < ints.length; k++) {
                    if (c == ints[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private double getCFromAAndB(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }

}
