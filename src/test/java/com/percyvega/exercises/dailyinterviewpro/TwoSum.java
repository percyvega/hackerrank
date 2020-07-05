package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class TwoSum {

    @Test
    void testThis() {
        assertThat(isTwoSum(new int[]{4, 7, 1, -3, 2}, 5)).isTrue();
        assertThat(isTwoSum(new int[]{4, -3, 2}, -1)).isTrue();
        assertThat(isTwoSum(new int[]{2, 3}, 5)).isTrue();
        assertThat(isTwoSum(new int[]{7, 2}, 9)).isTrue();
    }

    private boolean isTwoSum(int[] ints, int target) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] + ints[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

}
