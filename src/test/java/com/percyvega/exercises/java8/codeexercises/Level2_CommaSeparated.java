package com.percyvega.exercises.java8.codeexercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Level2_CommaSeparated {

    List<Integer> integerList = Arrays.asList(5, 8, 13);
    String expected = "e5,o8,e13";

    @Test
    void test() {
        assertThat(getString(integerList)).isEqualTo(expected);
    }

    public String getString(List<Integer> list) {
        return list.stream()
                .map(integer -> Integer.toString(integer))
                .reduce("", (s1, s2) -> {
                    String toReturn = "";
                    if (s1.length() != 0) {
                        toReturn = s1 + ",";
                    }
                    toReturn += Integer.parseInt(s2) % 2 == 0 ? "o" : "e";
                    toReturn += s2;

                    return toReturn;
                });
    }

}
