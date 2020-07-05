package com.percyvega.exercises.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class NonDecreasingArrayWithSingleModification {

    @Test
    void testThis() {
        assertThat(isNonDecreasingAfterSingleModification(13, 4, 7)).isTrue();
        assertThat(isNonDecreasingAfterSingleModification(5, 1, 3)).isTrue();
        assertThat(isNonDecreasingAfterSingleModification(5, 1, 3, 2)).isFalse();
        assertThat(isNonDecreasingAfterSingleModification(5, 1, 3, 3, 5)).isTrue();
        assertThat(isNonDecreasingAfterSingleModification(5, 1, 1, 3, 5)).isTrue();
    }

    private boolean isNonDecreasingAfterSingleModification(int... ints) {
        boolean usedSingleModification = false;
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                if (usedSingleModification) {
                    return false;
                } else {
                    usedSingleModification = true;
                    ints[i] = ints[i + 1];
                }
            }
        }

        return true;
    }

}
