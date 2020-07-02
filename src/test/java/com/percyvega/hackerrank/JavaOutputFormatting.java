package com.percyvega.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaOutputFormatting {

    @Test
    void testFormatToPrint() {
        assertThat(formatToPrint("java", 100)).isEqualTo("java           100");
        assertThat(formatToPrint("cpp", 65)).isEqualTo("cpp            065");
        assertThat(formatToPrint("python", 50)).isEqualTo("python         050");
    }

    static String formatToPrint(String s, int i) {
        return String.format("%-15s%03d", s, i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.println(formatToPrint(s1, x));
        }
        System.out.println("================================");
    }

}
