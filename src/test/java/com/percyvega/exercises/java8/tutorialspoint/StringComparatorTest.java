package com.percyvega.exercises.java8.tutorialspoint;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class StringComparatorTest {

    List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");

    @Test
    void use_default_method() {
        StringComparator sc = new StringComparatorX();
        stringList.sort(sc::defaultComparison);
        log.info(stringList);
    }

    @Test
    void use_sam_method() {
        StringComparator sc = new StringComparatorY();
        stringList.sort(sc::compare);
        log.info(stringList);
    }

    @Test
    void use_default_method_inside_sam_implementation() {
        StringComparator sc = new StringComparatorZ();
        stringList.sort(sc::compare);
        log.info(stringList);
    }

}
