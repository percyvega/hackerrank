package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class MinimumSizeSubarraySum {

    @Test
    void testThis() {
        assertThat(getMinSubarrayLength(new int[]{10}, 20)).isEqualTo(0);
        assertThat(getMinSubarrayLength(new int[]{10}, 10)).isEqualTo(1);
        assertThat(getMinSubarrayLength(new int[]{10}, 5)).isEqualTo(1);

        assertThat(getMinSubarrayLength(new int[]{2, 3, 1, 2, 4, 3}, 7)).isEqualTo(2);

        assertThat(getMinSubarrayLength(new int[]{1, 3, 6, 4, 1, 2}, 10)).isEqualTo(2);
        assertThat(getMinSubarrayLength(new int[]{1, 2, 2, 1, 1, 4, 3, 3}, 8)).isEqualTo(3);
    }

    private int getMinSubarrayLength(int[] nums, int s) {
        for (int subarrayLength = 1; subarrayLength <= nums.length; subarrayLength++) {
            for (int i = 0; i <= nums.length - subarrayLength; i++) {
                int sum = sumFromTo(nums, i, i + subarrayLength - 1);
                if (sum >= s) {
                    return subarrayLength;
                }
            }
        }

        return 0;
    }

    private int sumFromTo(int[] nums, int i, int j) {
        int sum = 0;

        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }

        return sum;
    }

}
