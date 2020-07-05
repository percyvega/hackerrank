package com.percyvega.exercises.java8.codeexercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two strings, write a method that finds the longest common sub-sequence.
 */
public class Level3_LongestCommonSequence {

    @Test
    void getSequenceThatStarts() {
        assertThat(getSequenceThatStarts("abcDEFG", "abcXYZ")).isEqualTo("abc");
        assertThat(getSequenceThatStarts("XYZ", "abcXYZ")).isEqualTo("");
    }

    @Test
    void getLongestCommonSequence() {
        assertThat(getLongestCommonSequence("abcDEFG", "abcXYZ")).isEqualTo("abc");
        assertThat(getLongestCommonSequence("XYZ", "abcXYZ")).isEqualTo("XYZ");
        assertThat(getLongestCommonSequence("abc_DEFG", "abc-DEFG")).isEqualTo("DEFG");
        assertThat(getLongestCommonSequence("XYZabcd", "abcdXYZ")).isEqualTo("abcd");
        assertThat(getLongestCommonSequence("abcde", "abcde")).isEqualTo("abcde");
        assertThat(getLongestCommonSequence("abcdef", "abcde")).isEqualTo("abcde");
        assertThat(getLongestCommonSequence("abcde", "abcdef")).isEqualTo("abcde");
        assertThat(getLongestCommonSequence("abc", "def")).isEqualTo("");
    }

    private String getLongestCommonSequence(String s1, String s2) {
        String longestCommonSequence = "";

        for (int i = 0; i < s1.length(); i++) {
            String s11 = s1.substring(i);
            for (int j = 0; j < s2.length(); j++) {
                String s22 = s2.substring(j);
                String sequenceThatStarts = getSequenceThatStarts(s11, s22);
                if(sequenceThatStarts.length() > longestCommonSequence.length()) {
                    longestCommonSequence = sequenceThatStarts;
                }
            }
        }

        return longestCommonSequence;
    }

    private String getSequenceThatStarts(String s1, String s2) {
        int i = 0;
        for (; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }

        return s1.substring(0, i);
    }

}
