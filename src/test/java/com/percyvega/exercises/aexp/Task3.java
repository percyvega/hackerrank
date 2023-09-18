package com.percyvega.exercises.aexp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task3 {

    public int solution(int[] A) {
        int length = 1;
        int nextIndex = 0;

        while (A[nextIndex] != -1) {
            ++length;
            nextIndex = A[nextIndex];
        }

        return length;
    }

    @Test
    void test1() {
        assertThat(solution(new int[]{1, 4, -1, 3, 2})).isEqualTo(4);
    }
}