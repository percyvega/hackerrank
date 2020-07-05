package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class AddTwoNumbersAsALinkedList {

    @Test
    void test1() {
        List<Integer> n1 = Arrays.asList(2, 4, 3);
        List<Integer> n2 = Arrays.asList(5, 6, 4);

        assertThat(addTwoNumbers(n1, n2)).isEqualTo(Arrays.asList(7, 0, 8));
    }

    @Test
    void test2() {
        List<Integer> n1 = Arrays.asList(0);
        List<Integer> n2 = Arrays.asList(3, 7, 8);

        assertThat(addTwoNumbers(n1, n2)).isEqualTo(Arrays.asList(3, 7, 8));
    }

    @Test
    void test3() {
        List<Integer> n1 = Arrays.asList(4, 5, 6);
        List<Integer> n2 = Arrays.asList(6, 4, 3);

        assertThat(addTwoNumbers(n1, n2)).isEqualTo(Arrays.asList(0, 0, 0, 1));
    }

    private List<Integer> addTwoNumbers(List<Integer> n1, List<Integer> n2) {
        List<Integer> sum = new ArrayList<>();

        int carryOver = 0;
        int countDigits = Math.max(n1.size(), n2.size());
        for (int i = 0; i < countDigits; i++) {
            int iN1 = n1.size() <= i ? 0 : n1.get(i);
            int iN2 = n2.size() <= i ? 0 : n2.get(i);

            int iN = iN1 + iN2 + carryOver;
            carryOver = iN >= 10 ? 1 : 0;

            sum.add(iN % 10);
        }

        if (carryOver == 1) {
            sum.add(1);
        }

        return sum;
    }

}

