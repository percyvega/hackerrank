package com.percyvega.exercises.dailyinterviewpro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateBalancedParentheses {

    private String openingParentheses = "[({";
    private String closingParentheses = "])}";

    @Test
    void isValidTest() {
        assertThat(isValid("((()))")).isTrue();
        assertThat(isValid("[()]{}")).isTrue();
        assertThat(isValid("({[)]")).isFalse();
        Assertions.assertThrows(IllegalArgumentException.class, () -> isValid("(a)"));
    }

    boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpeningParenthesis(c)) {
                characters.push(c);
            } else if (isClosingParentheses(c)) {
                int indexInClosing = closingParentheses.indexOf(c);
                char openingCounterpart = openingParentheses.charAt(indexInClosing);

                Character previousChar = characters.pop();
                if (previousChar != openingCounterpart) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException(c + " is not a parenthesis");
            }
        }

        return characters.empty();
    }

    private boolean isOpeningParenthesis(char c) {
        return openingParentheses.indexOf(c) != -1;
    }

    private boolean isClosingParentheses(char c) {
        return closingParentheses.indexOf(c) != -1;
    }

}
