package com.percyvega.exercises.aexp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task2 {

    @Test
    void testSolution() {
        assertThat(solution(1)).isEqualTo(-1);      // 1
        assertThat(solution(2)).isEqualTo(-1);      // 10
        assertThat(solution(3)).isEqualTo(1);       // 1 1
        assertThat(solution(5)).isEqualTo(-1);      // 101
        assertThat(solution(10)).isEqualTo(2);      // 10 10
        assertThat(solution(15)).isEqualTo(1);      // 1111
        assertThat(solution(27)).isEqualTo(-1);     // 11011
        assertThat(solution(955)).isEqualTo(4);     // 1110 1110 11
        assertThat(solution(3835)).isEqualTo(6);    // 111011 111011
    }

    int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }

        for (p = 1; p < l / 2 + 1; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l / 2; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

}