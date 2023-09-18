package com.percyvega.exercises.hackerrank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaOutputFormattingTest {

    @Test
    void testFormatToPrint() {
        assertThat(formatToPrint("java", 100)).isEqualTo("java           100");
        assertThat(formatToPrint("cpp", 65)).isEqualTo("cpp            065");
        assertThat(formatToPrint("python", 50)).isEqualTo("python         050");
    }

    static String formatToPrint(String s, int i) {
        return String.format("%-15s%03d", s, i);
    }

}
