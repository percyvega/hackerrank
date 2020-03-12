package com.percyvega.various.ae;

import org.junit.jupiter.api.Test;

class Task4 {

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
        System.out.println(solution(new int[]{1, 4, -1, 3, 2}));
    }
}