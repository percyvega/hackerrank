package com.percyvega.various.aexp;

import org.junit.jupiter.api.Test;

class Task3 {

    private final static String L = "L";

    public void solution(int N) {
        for (int i = 1; i < N; i++) {
            System.out.println(L);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(L);
        }
    }

    @Test
    void test1() {
        solution(1);
    }

    @Test
    void test2() {
        solution(2);
    }

    @Test
    void test3() {
        solution(3);
    }

    @Test
    void test4() {
        solution(4);
    }

}