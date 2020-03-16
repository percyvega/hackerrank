package com.percyvega.practice.java8.codeexercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CommaSeparated {

    List<Integer> integerList = Arrays.asList(5, 8, 13);
    String expected = "e5,o8,e13";

    @Test
    void test() {
        assertThat(getString(integerList)).isEqualTo(expected);
    }

    public String getString(List<Integer> list) {
        return list.stream()
                .map(integer -> Integer.toString(integer))
                .reduce("", (s, s2) -> {
                    String toReturn = "";
                    if(s.length() != 0) {
                        toReturn = s + ",";
                    }
                    toReturn += Integer.parseInt(s2) % 2 == 0 ? "o": "e";
                    toReturn += s2;

                    return toReturn;
                });
    }

}
