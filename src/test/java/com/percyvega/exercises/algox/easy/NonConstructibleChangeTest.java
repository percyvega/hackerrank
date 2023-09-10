package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NonConstructibleChangeTest {

    // O(n log(n)) time | O(1) space - where n is the number of coins
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int total = 0;

        for (int coin : coins) {
            if (coin > total + 1) {
                return total + 1;
            }
            total += coin;
        }

        return total + 1;
    }

    @Test
    void testNonConstructibleChange() {
        int[] coins = new int[]{};
        assertThat(nonConstructibleChange(coins)).isEqualTo(1);

        coins = new int[]{2};
        assertThat(nonConstructibleChange(coins)).isEqualTo(1);

        coins = new int[]{1};
        assertThat(nonConstructibleChange(coins)).isEqualTo(2);

        coins = new int[]{1, 1};
        assertThat(nonConstructibleChange(coins)).isEqualTo(3);

        coins = new int[]{1, 2, 5};
        assertThat(nonConstructibleChange(coins)).isEqualTo(4);

        coins = new int[]{1, 2, 3, 5, 7, 22};
        assertThat(nonConstructibleChange(coins)).isEqualTo(19);

        coins = new int[]{1, 1, 2, 3, 5, 7, 22};
        assertThat(nonConstructibleChange(coins)).isEqualTo(20);

        coins = new int[]{1, 3, 6};
        assertThat(nonConstructibleChange(coins)).isEqualTo(2);

        coins = new int[]{1, 2, 4, 7};
        assertThat(nonConstructibleChange(coins)).isEqualTo(15);
    }

}
