package com.percyvega.exercises.java8.stackoverflow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FindStringMaxLengthInList {

    List<String> names = Arrays.asList("Nico", "Isa", "Fran", "Percy");

    @Test
    void test() {
        OptionalInt maxLength = names.stream()
                .mapToInt(String::length)
                .max();

        assertThat(maxLength.isPresent()).isTrue();
        assertThat(maxLength.getAsInt()).isEqualTo(5);
    }
}
