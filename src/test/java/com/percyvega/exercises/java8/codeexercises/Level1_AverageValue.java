package com.percyvega.exercises.java8.codeexercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import static org.assertj.core.api.Assertions.assertThat;

public class Level1_AverageValue {

    List<Integer> integerList = Arrays.asList(1, 2, 3, 5, 8, 13);
    Double average = (1 + 2 + 3 + 5 + 8 + 13) / 6.0;

    @Test
    void test() {
        assertThat(average(integerList)).isEqualTo(average);
    }

    public Double average(List<Integer> list) {
        OptionalDouble average = list.stream()
                .mapToInt(value -> value)
                .average();
        return average.getAsDouble();
    }

}
