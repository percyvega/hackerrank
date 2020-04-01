package com.percyvega.practice.java8.stackoverflow;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateTwoListsBasedOnCondition {

    Predicate<String> lengthGreaterThan4 = (s) -> s.length() > 4;
    List<String> names = Arrays.asList("Nico", "Isa", "Fran", "Percy");

    @Test
    void reading_the_list_once() {
        Map<String, List<String>> collect = names.stream()
                .collect(Collectors.groupingBy(s -> s.length() > 4 ? "gt4" : "ngt4"));
        assertThat(collect.get("gt4")).containsExactly("Percy");
        assertThat(collect.get("ngt4")).containsExactly("Nico", "Isa", "Fran");
    }

    @Test
    void reading_the_list_twice() {
        List<String> namesLengthGreaterThan4 = names.stream()
                .filter(lengthGreaterThan4)
                .collect(Collectors.toList());
        List<String> namesLengthNotGreaterThan4 = names.stream()
                .filter(lengthGreaterThan4.negate())
                .collect(Collectors.toList());

        assertThat(namesLengthGreaterThan4).containsExactly("Percy");
        assertThat(namesLengthNotGreaterThan4).containsExactly("Nico", "Isa", "Fran");
    }

}
