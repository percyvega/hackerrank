package com.percyvega.hr;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortJavaBigDecimalStrings {

    @Test
    void test() {
        int countElements = 10;

        String[] s = new String[]{
                "9",
                "-100",
                "50",
                "0",
                "56.6",
                "90",
                "0.12",
                ".12",
                "02.34",
                "000.000"
        };

        String[] expectedOutput = new String[]{
                "90",
                "56.6",
                "50",
                "9",
                "02.34",
                "0.12",
                ".12",
                "0",
                "000.000",
                "-100"
        };

        assertThat(sortBigDecimals(countElements, s)).containsExactly(expectedOutput);
    }

    public static String[] sortBigDecimals(int n, String[] s) {
        List<String> stringsList = Arrays.asList(s.clone());

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                BigDecimal x = new BigDecimal(s[i]);
                BigDecimal y = new BigDecimal(s[j]);

                int compareTo = x.compareTo(y);
                if(compareTo < 0) {
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                } else if (compareTo == 0) {
                    if(stringsList.indexOf(s[i]) > stringsList.indexOf(s[j])) {
                        String temp = s[i];
                        s[i] = s[j];
                        s[j] = temp;
                    }
                }
            }
        }

        return s;
    }

}
