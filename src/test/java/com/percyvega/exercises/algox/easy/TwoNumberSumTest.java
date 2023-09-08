package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoNumberSumTest {

    // O(n^2) time | O(1) space
    public static int[] twoNumberSum1(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }

        return new int[0];
    }

    // O(n) time | O(n) space
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for (int iNum : array) {
            int subs = targetSum - iNum;
            if (nums.contains(subs)) {
                return new int[]{subs, iNum};
            } else {
                nums.add(iNum);
            }
        }

        return new int[0];
    }

    // O(n log(n)) time | O(1) space
    public static int[] twoNumberSum3(int[] array, int targetSum) {
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int total = array[left] + array[right];
            if (total > targetSum) {
                right--;
            } else if (total < targetSum) {
                left++;
            } else {
                return new int[]{array[left], array[right]};
            }
        }

        return new int[0];
    }

    @Test
    void testTwoNumberSum() {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        int[] expected = new int[]{11, -1};

        assertThat(twoNumberSum1(array, targetSum)).containsExactlyInAnyOrder(expected);
        assertThat(twoNumberSum2(array, targetSum)).containsExactlyInAnyOrder(expected);
        assertThat(twoNumberSum3(array, targetSum)).containsExactlyInAnyOrder(expected);
    }
}
