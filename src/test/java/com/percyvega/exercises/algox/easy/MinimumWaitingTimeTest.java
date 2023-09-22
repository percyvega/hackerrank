package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumWaitingTimeTest {

    // O(n log(n)) time | O(1) space - where n is the number of elements of the input array.
    // O(n log(n)) time because we are sorting, otherwise it would be O(n) time.
    // O(1) time because sorting is in place, and we don't require any extra space.
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        var totalWaitingTime = 0;

        for (int i = 0; i < queries.length - 1; i++) {
            totalWaitingTime += queries[i] * (queries.length - 1 - i);
        }

        return totalWaitingTime;
    }

    @Test
    void testMinimumWaitingTime() {
        assertThat(minimumWaitingTime(new int[]{5})).isEqualTo(0);
        assertThat(minimumWaitingTime(new int[]{5, 1})).isEqualTo(1);
        assertThat(minimumWaitingTime(new int[]{5, 1, 4})).isEqualTo(6);
        assertThat(minimumWaitingTime(new int[]{5, 1, 4, 2, 6})).isEqualTo(23);
    }

}
