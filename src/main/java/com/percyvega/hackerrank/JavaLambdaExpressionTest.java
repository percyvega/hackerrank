package com.percyvega.hackerrank;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.function.Predicate;

@Log4j2
public class JavaLambdaExpressionTest {

    String s = "5\n" +
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
        BufferedReader bufferedReader = new BufferedReader(new StringReader(s));
        String s = bufferedReader.readLine();
        int countRows = Integer.parseInt(s);
        for (int i = 0; i < countRows; i++) {
            s = bufferedReader.readLine();

            String[] strings = s.split(" ");
            int n = Integer.parseInt(strings[1]);
            switch (strings[0]) {
                case "1":
                    if (isOdd.test(n)) {
                        log.info("ODD");
                    } else {
                        log.info("EVEN");
                    }
                    break;
                case "2":
                    if (isPrime.test(n)) {
                        log.info("PRIME");
                    } else {
                        log.info("COMPOSITE");
                    }
                    break;
                case "3":
                    if (isPalindrome.test(n)) {
                        log.info("PALINDROME");
                    } else {
                        log.info("NOT PALINDROME");
                    }
                    break;
            }
        }
    }

}
