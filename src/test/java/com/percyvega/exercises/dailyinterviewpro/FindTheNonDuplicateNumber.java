package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class FindTheNonDuplicateNumber {

    @Test
    void testGetNonDup1() {
        assertThat(getNonDup1(4, 3, 2, 4, 1, 3, 2)).isEqualTo(1);
        assertThat(getNonDup1(4, 2, 4)).isEqualTo(2);
        assertThat(getNonDup1(7, 2, 2)).isEqualTo(7);
        assertThat(getNonDup1(2)).isEqualTo(2);
    }

    @Test
    void testGetNonDup2() {
        assertThat(getNonDup2(4, 3, 2, 4, 1, 3, 2)).isEqualTo(1);
        assertThat(getNonDup2(4, 2, 4)).isEqualTo(2);
        assertThat(getNonDup2(7, 2, 2)).isEqualTo(7);
        assertThat(getNonDup2(2)).isEqualTo(2);
    }

    // Linear time i.e. O(n)
    private Integer getNonDup1(int... ints) {
        List<Integer> numList = new LinkedList<>();
        for (int i = 0; i < ints.length; i++) {
            Integer num = ints[i];
            if (numList.contains(num)) {
                numList.remove(num);
            } else {
                numList.add(num);
            }
        }

        return numList.get(0);
    }

    // No additional memory i.e. O(1)
    private Integer getNonDup2(int... ints) {
        loop1:
        for (int i = 0; i < ints.length; i++) {
            int num1 = ints[i];
            for (int j = 0; j < ints.length; j++) {
                int num2 = ints[j];
                if (i == j) {
                    continue;
                }
                if (num1 == num2) {
                    continue loop1;
                }
            }
            return num1;
        }

        return null;
    }

}
