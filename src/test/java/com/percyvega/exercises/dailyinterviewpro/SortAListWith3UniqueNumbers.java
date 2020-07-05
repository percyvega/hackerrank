package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class SortAListWith3UniqueNumbers {

    @Test
    void testThis() {
        assertThat(sortList(3, 3, 2, 1, 3, 2, 1)).isEqualTo(new int[]{1, 1, 2, 2, 3, 3, 3});
    }

    private int[] sortList(int... intArray) {
        Map<Integer, Integer> keyCount = new TreeMap<>();

        for (int key : intArray) {
            if (keyCount.containsKey(key)) {
                int value = keyCount.get(key).intValue();
                keyCount.put(key, ++value);
            } else {
                keyCount.put(key, 1);
            }
        }

        int[] sortedList = new int[intArray.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : keyCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sortedList[index++] = entry.getKey();
            }
        }

        return sortedList;
    }

}
