package com.percyvega.exercises.java8.stackoverflow;

import lombok.extern.log4j.Log4j2;
import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * How do I convert a List<Entry> to Map<Entry::getKey, List<Entry::getValue>> using streams in Java 8?
 */
@Log4j2
public class ConvertListEntryToMapEntryKeyValue {

    static List<MapEntry<String, Integer>> listEntries = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        listEntries.add(MapEntry.entry("Father", 40));
        listEntries.add(MapEntry.entry("Mother", 33));
        listEntries.add(MapEntry.entry("Son", 4));
        listEntries.add(MapEntry.entry("Daughter", 1));
    }

    @Test
    void test() {
        Map<String, Integer> map = listEntries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        assertThat(map.get("Son")).isEqualTo(4);
    }

}
