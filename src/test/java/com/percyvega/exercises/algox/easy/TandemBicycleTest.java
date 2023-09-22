package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class TandemBicycleTest {

    // Time: O(n log(n)) because of the sorting algorithm.
    // Space: O(1) because sorting is done in-place.
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        var totalSpeed = 0;

        Arrays.sort(redShirtSpeeds);
        if (fastest) {
            // calculate maximum total speed
            blueShirtSpeeds = Arrays.stream(blueShirtSpeeds)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        } else {
            // calculate minimum total speed
            Arrays.sort(blueShirtSpeeds);
        }

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }

        return totalSpeed;
    }

    @Test
    void testTandemBicycle() {
        assertThat(tandemBicycle(new int[]{1, 4}, new int[]{5, 3}, true)).isEqualTo(9);
        assertThat(tandemBicycle(new int[]{5, 5, 3, 9, 2}, new int[]{3, 6, 7, 2, 1}, true)).isEqualTo(32);
    }

}
