package com.percyvega.exercises.java8.codeexercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A palindrome is a word which reads the same backward or forward.
 * 'abcba' is a palindrome.
 * Write a method that returns the longest palindrome substring of a given string.
 */
public class Level3_LongestPalindromeInWord {

    String stringContainingPalindromes = "sagas" + "abc" + "noon" + "abc" + "racecar" + "abc" + "wow";

    @Test
    void getIfPalindromeTest() {
        assertThat(getIfPalindrome("abc" + "a")).isNull();
        assertThat(getIfPalindrome("sagas" + "abc")).isNull();
        assertThat(getIfPalindrome("sagas" + "abc")).isNull();
        assertThat(getIfPalindrome("a" + "sagas")).isNull();

        assertThat(getIfPalindrome("a")).isEqualTo("a");
        assertThat(getIfPalindrome("sagas")).isEqualTo("sagas");
    }

    @Test
    void getLongestPalindrome() {
        assertThat(getLongestPalindromeInWord("abc" + "abc")).isEqualTo("a");

        assertThat(getLongestPalindromeInWord("a" + "abc")).isEqualTo("aa");
        assertThat(getLongestPalindromeInWord("sagas")).isEqualTo("sagas");
        assertThat(getLongestPalindromeInWord("sagas" + "abc")).isEqualTo("sagas");
        assertThat(getLongestPalindromeInWord("abc" + "sagas" + "abc")).isEqualTo("sagas");
        assertThat(getLongestPalindromeInWord("sagas" + "abc" + "racecar")).isEqualTo("racecar");
        assertThat(getLongestPalindromeInWord(stringContainingPalindromes)).isEqualTo("racecar");
    }

    private String getLongestPalindromeInWord(String s) {
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String substring = s.substring(i, j);

                String palindrome = getIfPalindrome(substring);

                if (palindrome != null) {
                    if (palindrome.length() > longestPalindrome.length()) {
                        longestPalindrome = palindrome;
                    }
                }
            }
        }

        return longestPalindrome;
    }

    private static String getIfPalindrome(String s) {
        for (int k = 0; k < (s.length()) / 2; k++) {
            char c1 = s.charAt(k);
            char c2 = s.charAt(s.length() - k - 1);
            if (c1 != c2) {
                return null;
            }
        }
        return s;
    }

}
