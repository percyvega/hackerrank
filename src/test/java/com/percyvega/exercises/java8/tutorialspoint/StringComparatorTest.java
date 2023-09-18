package com.percyvega.exercises.java8.tutorialspoint;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class StringComparatorTest {

    List<String> stringList = Arrays.asList("Percy", "Francesca", "Nicholas", "Isabella");

    @Test
    void use_default_method() {
        StringComparator sc = new StringComparatorX();
        stringList.sort(sc::defaultComparison);
        assertThat(stringList).containsExactly("Percy", "Nicholas", "Isabella", "Francesca");
    }

    @Test
    void use_sam_method() {
        StringComparator sc = new StringComparatorY();
        stringList.sort(sc::compare);
        assertThat(stringList).containsExactly("Francesca", "Isabella", "Nicholas", "Percy");
    }

    @Test
    void use_default_method_inside_sam_implementation() {
        StringComparator sc = new StringComparatorZ();
        stringList.sort(sc::compare);
        assertThat(stringList).containsExactly("Percy", "Nicholas", "Isabella", "Francesca");
    }

}
