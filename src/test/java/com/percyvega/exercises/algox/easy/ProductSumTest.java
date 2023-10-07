package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSumTest {

    // Time: O(n) where n is the number of elements in the list
    // Space: O(h) where h is the level of the innermost array
    public static int productSum(List<Object> list) {
        return sumListValuesOfLevel(list, 1);
    }

    private static int sumListValuesOfLevel(List<?> list, int level) {
        int total = 0;

        for (Object o : list) {

            if (o instanceof List<?> innerList) {
                total += sumListValuesOfLevel(innerList, level + 1);
            } else {
                total += (Integer) o;
            }

        }

        return level * total;
    }

    @Test
    void testProductSum() {
        assertThat(productSum(List.of(5, 2))).isEqualTo(7);
        assertThat(productSum(List.of(List.of(7, -1)))).isEqualTo(12);
        assertThat(productSum(List.of(5, 2, List.of(7, -1)))).isEqualTo(19);
        assertThat(productSum(List.of(5, 2, List.of(7, -1), 3))).isEqualTo(22);
        assertThat(productSum(List.of(List.of(6, List.of(-13, 8), 4)))).isEqualTo(-10);
        assertThat(productSum(List.of(5, 2, List.of(7, -1), 3, List.of(6, List.of(-13, 8), 4)))).isEqualTo(12);
    }

}
