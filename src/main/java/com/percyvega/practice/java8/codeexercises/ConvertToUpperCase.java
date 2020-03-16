package com.percyvega.practice.java8.codeexercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertToUpperCase {

    List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");
    List<String> expected = Arrays.asList("PERCY", "FRANCESCA", "NICHOLAS", "ISABELLA");

    @Test
    void test() {
        assertThat(upperCase(stringList)).isEqualTo(expected);
    }

    public List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

}
