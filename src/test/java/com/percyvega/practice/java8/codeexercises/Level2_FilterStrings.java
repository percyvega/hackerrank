package com.percyvega.practice.java8.codeexercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Level2_FilterStrings {

    List<String> stringList = Arrays.asList("cat", "and", "axyz", "pet", "abc");

    @Test
    void test() {
        assertThat(search(stringList)).containsExactly("and", "abc");
    }

    public List<String> search(List<String> list) {
        return list.stream()
                .filter(s -> s.startsWith("a") && s.length() == 3)
                .collect(Collectors.toList());
    }

}
