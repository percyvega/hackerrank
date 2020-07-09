package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.stack.Stack;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class MaximumInAStack {

    @Test
    void testThis() {
        assertThat(max(Stack.of(2, 3))).isEqualTo(3);
        assertThat(max(Stack.of(7, 2))).isEqualTo(7);
        assertThat(max(Stack.of(4, -3, 2))).isEqualTo(4);
        assertThat(max(Stack.of(4, 7, 1, -3, 2))).isEqualTo(7);
    }

    private <E extends Comparable<E>> E max(Stack<E> stack) {
        E maxFound = stack.pop();
        while (stack.size() > 0) {
            E e = stack.pop();
            if (e.compareTo(maxFound) > 0) {
                maxFound = e;
            }
        }

        return maxFound;
    }

}
