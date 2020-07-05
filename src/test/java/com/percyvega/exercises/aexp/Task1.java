package com.percyvega.exercises.aexp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
class Task1 {

    String wordWithLettersToRemove = "BALLOON";

    @Test
    void testSmallestPositiveIntegerNotFoundInArray() {
        assertThat(solution("CS")).isEqualTo(0);
        assertThat(solution("BA")).isEqualTo(0);
        assertThat(solution("BAOOLLNNOLOLGBAX")).isEqualTo(2);
        assertThat(solution("QAWABAWONL")).isEqualTo(0);
        assertThat(solution("ONLABLABLOON")).isEqualTo(1);
        assertThat(solution("BALLOON")).isEqualTo(1);
    }

    private int solution(String S) {
        char[] charArray = S.toCharArray();
        if (removeWordLettersFromString(charArray)) {
            return 1 + solution(Arrays.toString(charArray));
        } else {
            return 0;
        }
    }

    private boolean removeWordLettersFromString(char[] S) {
        for (int i = 0; i < wordWithLettersToRemove.length(); i++) {
            char letterToFind = wordWithLettersToRemove.charAt(i);
            boolean letterFound = false;

            for (int j = 0; j < S.length; j++) {
                if (S[j] == letterToFind) {
                    S[j] = '-';
                    letterFound = true;
                    break;
                }
            }

            if (!letterFound) {
                return false;
            }
        }

        return true;
    }

}
