package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NthFibonacciTest {

    private static Long[] cachedFibValues;

    // Time: O(n) time, because it iterates n times.
    // Space: O(1) space, because it doesn't need any extra space.
    private static long getNthFibIterative(int n) {
        long F0 = 0;
        long F1 = 1;

        if (n <= 1) {
            return F0;
        } else if (n == 2) {
            return F1;
        } else {
            for (int i = 3; i <= n; i++) {
                long sum = F0 + F1;
                if(i == n) {
                    return sum;
                } else {
                    F0 = F1;
                    F1 = sum;
                }
            }

            return F0 + F1;
        }
    }


    // Time: O(2^n) time, bBecause it ends up being a binary tree of calls.
    // Space: O(n) space, because for any branch, it will only go as deep as n levels. They will not run in parallel.
    private static long getNthFibWithoutCache(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getNthFibWithoutCache(n - 1) + getNthFibWithoutCache(n - 2);
        }
    }

    // Time: O(n) time, where n is the fibonacci we are to calculate.
    // Time: O(n) space, because the cache is n in size.
    public static long getNthFibWithCache(int n) {
        if (n < 1) {
            throw new RuntimeException("Invalid value for N: " + n);
        }

        cachedFibValues = new Long[n + 1];

        return getFibValue(n);
    }

    private static long getFibValue(int n) {
        if (cachedFibValues[n] != null) {
            return cachedFibValues[n];
        } else {
            long value;
            if (n == 1) {
                value = 0;
            } else if (n == 2) {
                value = 1;
            } else {
                value = getFibValue(n - 1) + getFibValue(n - 2);
            }
            cachedFibValues[n] = value;
            return value;
        }
    }

    @Test
    void testGetNthFibIterative() {
        assertThat(getNthFibIterative(1)).isEqualTo(0);
        assertThat(getNthFibIterative(2)).isEqualTo(1);
        assertThat(getNthFibIterative(3)).isEqualTo(1);
        assertThat(getNthFibIterative(4)).isEqualTo(2);
        assertThat(getNthFibIterative(5)).isEqualTo(3);
        assertThat(getNthFibIterative(6)).isEqualTo(5);

        assertThat(getNthFibIterative(10)).isEqualTo(34);
        assertThat(getNthFibIterative(20)).isEqualTo(4181);
        assertThat(getNthFibIterative(30)).isEqualTo(514229);
        assertThat(getNthFibIterative(40)).isEqualTo(63245986);
    }
    @Test
    void testGetNthFibonacciWithCache() {
        assertThat(getNthFibWithCache(1)).isEqualTo(0);
        assertThat(getNthFibWithCache(2)).isEqualTo(1);
        assertThat(getNthFibWithCache(3)).isEqualTo(1);
        assertThat(getNthFibWithCache(4)).isEqualTo(2);
        assertThat(getNthFibWithCache(5)).isEqualTo(3);
        assertThat(getNthFibWithCache(6)).isEqualTo(5);

        assertThat(getNthFibWithCache(10)).isEqualTo(34);
        assertThat(getNthFibWithCache(20)).isEqualTo(4181);
        assertThat(getNthFibWithCache(30)).isEqualTo(514229);
        assertThat(getNthFibWithCache(40)).isEqualTo(63245986);
    }

    @Test
    void testGetNthFibWithoutCache() {
        assertThat(getNthFibWithoutCache(1)).isEqualTo(0);
        assertThat(getNthFibWithoutCache(2)).isEqualTo(1);
        assertThat(getNthFibWithoutCache(3)).isEqualTo(1);
        assertThat(getNthFibWithoutCache(4)).isEqualTo(2);
        assertThat(getNthFibWithoutCache(5)).isEqualTo(3);
        assertThat(getNthFibWithoutCache(6)).isEqualTo(5);

        assertThat(getNthFibWithoutCache(10)).isEqualTo(34);
        assertThat(getNthFibWithoutCache(20)).isEqualTo(4181);
        assertThat(getNthFibWithoutCache(30)).isEqualTo(514229);
        assertThat(getNthFibWithoutCache(40)).isEqualTo(63245986);
    }

}
