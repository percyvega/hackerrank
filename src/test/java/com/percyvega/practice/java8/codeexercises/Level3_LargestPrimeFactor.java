package com.percyvega.practice.java8.codeexercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The prime factors of 455 are 5, 7 and 13.
 * Write a method that calculates the largest prime factor of a given number.
 */
public class Level3_LargestPrimeFactor {

    @Test
    void isPrime() {
        List<Integer> primerNumbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61);
        List<Integer> notPrimerNumbers = Arrays.asList(1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27);

        assertThat(primerNumbers).allMatch(Level3_LargestPrimeFactor::isPrime);
        assertThat(notPrimerNumbers).noneMatch(Level3_LargestPrimeFactor::isPrime);
    }

    @Test
    void getLargestPrimeFactor() {
        assertThat(getLargestPrimeFactor(4)).isEqualTo(2);
        assertThat(getLargestPrimeFactor(10)).isEqualTo(5);
        assertThat(getLargestPrimeFactor(145)).isEqualTo(29);
        assertThat(getLargestPrimeFactor(121)).isEqualTo(11);
        assertThat(getLargestPrimeFactor(455)).isEqualTo(13);
    }

    private int getLargestPrimeFactor(int n) {
        int largestPrimeFactor = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                if (n % i == 0) {
                    largestPrimeFactor = i;
                }
            }
        }

        return largestPrimeFactor;
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if (n < 4) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
