package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LongestSubstringWithoutRepeatingCharacters {

    @Test
    void test1() {
        assertThat(longestSubstringWithoutRepeatingCharacters("")).isEqualTo("");
        assertThat(longestSubstringWithoutRepeatingCharacters("a")).isEqualTo("a");
        assertThat(longestSubstringWithoutRepeatingCharacters("aa")).isEqualTo("a");
        assertThat(longestSubstringWithoutRepeatingCharacters("ab")).isEqualTo("ab");
        assertThat(longestSubstringWithoutRepeatingCharacters("abc")).isEqualTo("abc");
        assertThat(longestSubstringWithoutRepeatingCharacters("cabc")).isEqualTo("cab");
        assertThat(longestSubstringWithoutRepeatingCharacters("dddabc")).isEqualTo("dabc");
        assertThat(longestSubstringWithoutRepeatingCharacters("abrkaabcdefghijjxxx")).isEqualTo("abcdefghij");
    }

    private String longestSubstringWithoutRepeatingCharacters(String completeString) {
        String longestSubstring = "";

        if (completeString.length() == 1) {
            return completeString;
        }

        for (int i = 0; i < completeString.length(); i++) {
            for (int j = i + 1; j < completeString.length(); j++) {
                String substring = completeString.substring(i, j);
                char c = completeString.charAt(j);
                if (substring.indexOf(c) == -1) {
                    substring += c;

                    if (substring.length() > longestSubstring.length()) {
                        longestSubstring = substring;
                    }
                } else {
                    if (substring.length() > longestSubstring.length()) {
                        longestSubstring = substring;
                    }
                    break;
                }

            }
        }

        return longestSubstring;
    }

}

