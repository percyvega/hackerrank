package com.percyvega.exercises.hackerrank;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class JavaLambdaExpressionTest {

    String s =
            "1 4\n" +
                    "2 5\n" +
                    "3 898\n" +
                    "1 3\n" +
                    "2 12";

    Predicate<Integer> isOdd = (n) -> n % 2 == 1;
    Predicate<Integer> isPrime = (n) -> {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    };
    Predicate<Integer> isPalindrome = (n) -> {
        String nString = String.valueOf(n);
        for (int i = 0; i < nString.length() / 2; i++) {
            if (nString.charAt(i) != nString.charAt(nString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    };

    @Test
    void test() throws IOException {
        assertThat(isOdd.test(3)).isTrue();
        assertThat(isOdd.test(4)).isFalse();

        assertThat(isPrime.test(5)).isTrue();
        assertThat(isPrime.test(12)).isFalse();

        assertThat(isPalindrome.test(12321)).isTrue();
        assertThat(isPalindrome.test(1212)).isFalse();
    }

}
