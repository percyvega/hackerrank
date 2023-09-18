package com.percyvega.exercises.java8.tutorialspoint;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FromTutorialsPoint {

    @Test
    void test1() {
        List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");
        assertThat(stringList).containsExactly("Percy", "Francesca", "Nicholas", "Isabella");

        stringList.sort((o1, o2) -> o1.length() - o2.length());
        assertThat(stringList).containsExactly("Percy", "Nicholas", "Isabella", "Francesca");

        stringList.sort(Comparator.comparingInt(String::length));
        assertThat(stringList).containsExactly("Percy", "Nicholas", "Isabella", "Francesca");

        stringList.sort(String::compareTo);
        assertThat(stringList).containsExactly("Francesca", "Isabella", "Nicholas", "Percy");
    }

    @Test
    void print_10_random_numbers_using_forEach() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    void unique_squares_of_numbers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 5);
        List<Integer> unique = list.stream()
                .distinct()
                .map(i -> i * i)
                .toList();
        assertThat(unique).containsExactly(1, 4, 9, 16, 25);
    }

    @Test
    void printCountEmptyStrings() {
        List<String> stringList = Arrays.asList("Percy", "", "Francesca", "", "Nicholas", "", "Isabella");
        long count = stringList.stream()
                .filter(String::isEmpty)
                .count();
        assertThat(count).isEqualTo(3);
    }

    @Test
    void printSortedOrder() {
        List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");
        List<String> sortedList = stringList.stream()
                .sorted()
                .collect(Collectors.toList());
        assertThat(sortedList).containsExactly("Francesca", "Isabella", "Nicholas", "Percy");
    }

    @Test
    void get_the_highest_number_present_in_a_list() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 5);

        Optional<Integer> max = integers.stream()
                .max(Comparator.comparingInt(o -> o));
        assertThat(max.get()).isEqualTo(5);
    }

    @Test
    void get_the_sum_of_all_numbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        assertThat(integers.stream()
                .reduce(0, Integer::sum)).isEqualTo(15);
    }

    @Test
    void get_the_average_of_all_numbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt(x -> x).summaryStatistics();
        assertThat(intSummaryStatistics.getAverage()).isEqualTo(3);
    }

}