package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class WaysToTraverseAGrid {

    @Test
    void testThis() {
        assertThat(getNumberOfWays(1, 1)).isEqualTo(0);
        assertThat(getNumberOfWays(2, 1)).isEqualTo(1);
        assertThat(getNumberOfWays(1, 2)).isEqualTo(1);
        assertThat(getNumberOfWays(2, 2)).isEqualTo(2);
        assertThat(getNumberOfWays(3, 2)).isEqualTo(3);
        assertThat(getNumberOfWays(2, 3)).isEqualTo(3);
        assertThat(getNumberOfWays(3, 3)).isEqualTo(6);
        assertThat(getNumberOfWays(4, 3)).isEqualTo(10);
        assertThat(getNumberOfWays(5, 5)).isEqualTo(70);
    }

    private int getNumberOfWays(int r, int c) {
        if (r == 1 && c == 1) {
            return 0;
        } else if (r == 1 || c == 1) {
            return 1;
        }

        int numberOfWays = 0;

        numberOfWays += getNumberOfWays(r - 1, c);
        numberOfWays += getNumberOfWays(r, c - 1);

        return numberOfWays;
    }

}
