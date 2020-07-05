package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LongestPalindromicSubstring {

    @Test
    void test1() {
        assertThat(longestPalindromicSubstring("")).isEqualTo("");
        assertThat(longestPalindromicSubstring("a")).isEqualTo("a");
        assertThat(longestPalindromicSubstring("aa")).isEqualTo("aa");
        assertThat(longestPalindromicSubstring("ab")).isEqualTo("a");
        assertThat(longestPalindromicSubstring("aba")).isEqualTo("aba");
        assertThat(longestPalindromicSubstring("cabc")).isEqualTo("c");
        assertThat(longestPalindromicSubstring("dddabc")).isEqualTo("ddd");
        assertThat(longestPalindromicSubstring("banana")).isEqualTo("anana");
        assertThat(longestPalindromicSubstring("million")).isEqualTo("illi");
    }

    private String longestPalindromicSubstring(String completeString) {
        if (completeString.length() <= 1) {
            return completeString;
        }

        String longestSubstring = "";
        for (int i = 0; i < completeString.length(); i++) {
            for (int j = completeString.length(); j > i; j--) {
                String substring = completeString.substring(i, j);

                if (isPalindrome(substring)) {
                    if (substring.length() > longestSubstring.length()) {
                        longestSubstring = substring;
                    }
                    break;
                }
            }
        }

        return longestSubstring;
    }

    @Test
    void testIsPalindrome() {
        assertThat(isPalindrome("")).isTrue();
        assertThat(isPalindrome("a")).isTrue();
        assertThat(isPalindrome("aa")).isTrue();
        assertThat(isPalindrome("ab")).isFalse();
        assertThat(isPalindrome("aaa")).isTrue();
        assertThat(isPalindrome("aba")).isTrue();
        assertThat(isPalindrome("abc")).isFalse();
        assertThat(isPalindrome("abba")).isTrue();
        assertThat(isPalindrome("abbc")).isFalse();
        assertThat(isPalindrome("cabc")).isFalse();
        assertThat(isPalindrome("aaca")).isFalse();
        assertThat(isPalindrome("accca")).isTrue();
        assertThat(isPalindrome("accaacca")).isTrue();
    }

    private boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i -  1)) {
                return false;
            }
        }

        return true;
    }

}

