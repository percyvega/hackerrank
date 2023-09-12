package com.percyvega.exercises.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaDequeueTest {

    public static int getMaximumNumberOfUniqueIntegersFromSubarrays(int[] nums, int subarraysSize) {
        int maxUniqueLength = 0;
        for (int i = 0; i <= nums.length - subarraysSize; i++) {

            Set<Integer> uniqueNums = new HashSet<>();
            for (int j = 0; j < subarraysSize; j++) {
                uniqueNums.add(nums[i + j]);
            }

            if (maxUniqueLength < uniqueNums.size()) {
                maxUniqueLength = uniqueNums.size();
            }

        }

        return maxUniqueLength;
    }

    @Test
    void testJavaDequeue() {
        int[] nums = new int[]{5, 3, 5, 2, 3, 2};
        assertThat(getMaximumNumberOfUniqueIntegersFromSubarrays(nums, 3)).isEqualTo(3); // 3, 5, 2

        nums = new int[]{5, 3, 5, 1, 3, 2, 5, 6};
        assertThat(getMaximumNumberOfUniqueIntegersFromSubarrays(nums, 4)).isEqualTo(4);
        assertThat(getMaximumNumberOfUniqueIntegersFromSubarrays(nums, 5)).isEqualTo(5);
        assertThat(getMaximumNumberOfUniqueIntegersFromSubarrays(nums, 6)).isEqualTo(5);
    }

}
