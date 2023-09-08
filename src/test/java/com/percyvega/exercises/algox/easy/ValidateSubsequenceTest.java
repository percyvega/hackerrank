package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateSubsequenceTest {

    // O(n) time | O(1) space - where n is the length of array
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int foundCount = 0;

        int i = 0;
        int j = 0;

        while (i < sequence.size()) {
            Integer iInt = sequence.get(i++);
            while (j < array.size()) {
                Integer jInt = array.get(j++);

                if (iInt.equals(jInt)) {
                    foundCount++;
                    break;
                }
            }
        }
        return foundCount == sequence.size();
    }

    @Test
    void testValidateSubsequence() {
        List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 1);
        List<Integer> sequence = List.of(1, 6, -1, 10);

        assertThat(isValidSubsequence(array, sequence)).isFalse();

        array = List.of(5, 1, 22, 25, 6, -1, 8, 10);

        assertThat(isValidSubsequence(array, sequence)).isTrue();
    }

}
