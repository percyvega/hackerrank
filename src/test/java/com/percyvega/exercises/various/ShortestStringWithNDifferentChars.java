package com.percyvega.exercises.various;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestStringWithNDifferentChars {

    @Test
    void test0() {
        int numDiffChars = 7;
        String input = "aabcddeeeeeefghhhiabhcdttjk";
        assertEquals("iabhcdt", getShortestStringWithNDifferentChars(numDiffChars, input));
    }

    @Test
    void test1() {
        int numDiffChars = 10;
        String input = "aabcddeeeeeefghhhiabhcdttjk";
        assertEquals("efghhhiabhcdt", getShortestStringWithNDifferentChars(numDiffChars, input));
    }

    @Test
    void test2() {
        int numDiffChars = 11;
        String input = "aabcddeeeeeefghhhiabhcdttjk";
        assertEquals("efghhhiabhcdttj", getShortestStringWithNDifferentChars(numDiffChars, input));
    }

    private static String getShortestStringWithNDifferentChars(int numDiffChars, String input) {
        String shortestString = "";
        int n = 0;

        // optimization: "- numDiffChars + 1"
        outerloop:
        for (int i = 0; i < input.length() - numDiffChars + 1; i++) {

            int diffCharCounter = 0;
            Set<Character> setChars = new HashSet<>();
            char currentChar;
            String currentString = "";

            for (int j = i; j < input.length(); j++) {

                // optimization
                if (input.length() - j < numDiffChars - diffCharCounter) {
                    break outerloop;
                }

                // optimization
                if (!shortestString.isEmpty() && currentString.length() >= shortestString.length()) {
                    break;
                }

                n++;

                currentChar = input.charAt(j);
                currentString += currentChar;

                if (!setChars.contains(currentChar)) {
                    setChars.add(currentChar);
                    diffCharCounter++;

                    if (diffCharCounter == numDiffChars) {

                        if (shortestString.isEmpty() || currentString.length() < shortestString.length()) {
                            shortestString = currentString;
                        }

                        break;
                    }
                } else if (diffCharCounter == 1) {
                    // optimization
                    break;
                }
            }
        }

        System.out.println("n: " + n);
        return shortestString;
    }

}