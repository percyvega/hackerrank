package com.percyvega.exercises.java8.tutorialspoint;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.*;

@Log4j2
public class FromTutorialsPoint {

    @Test
    void test1() {
        List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");
        log.info(stringList);
        stringList.sort((o1, o2) -> o1.length() - o2.length());
        log.info(stringList);
        stringList.sort(Comparator.comparingInt(String::length));
        log.info(stringList);
        stringList.sort(String::compareTo);
        log.info(stringList);
    }

    @Test
    void print_10_random_numbers_using_forEach() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    void unique_squares_of_numbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 5);
        integers.stream()
                .distinct()
                .map(i -> i * i)
                .forEach(log::info);
    }

    @Test
    void printCountEmptyStrings() {
        List<String> stringList = Arrays.asList("Percy", "", "Francesca", "", "Nicholas", "", "Isabella");
        log.info(stringList.stream()
                .filter(s -> s.length() == 0)
                .count());
    }

    @Test
    void printSortedOrder() {
        List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");
        stringList.stream()
                .sorted()
                .forEach(log::info);
    }

    @Test
    void get_the_highest_number_present_in_a_list() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 5);

        Optional<Integer> max = integers.stream()
                .max(Comparator.comparingInt(o -> o));
        log.info(max.isPresent() ? max.get() : "");
    }

    @Test
    void get_the_sum_of_all_numbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        log.info(integers.stream()
                .reduce(0, Integer::sum));
    }

    @Test
    void get_the_average_of_all_numbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt(x -> x).summaryStatistics();
        log.info(intSummaryStatistics.getAverage());
    }

}