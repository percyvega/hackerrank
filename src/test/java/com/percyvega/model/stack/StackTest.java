package com.percyvega.model.stack;

import org.junit.jupiter.api.Test;

import static com.percyvega.model.stack.Stack.EMPTY_STACK_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StackTest {

    @Test
    void push() {
        Stack<String> s1 = new Stack<>();
        s1.push("a", "b", "c");
        assertThat(s1.size()).isEqualTo(3);

        assertThat(Stack.of("a", "b", "c").size()).isEqualTo(3);

        assertThat(new Stack<String>().push("a", "b", "c").size()).isEqualTo(3);
    }

    @Test
    void pop() {
        Stack<String> s = Stack.of("a", "b", "c");
        assertThat(s.pop()).isEqualTo("c");
        assertThat(s.pop()).isEqualTo("b");
        assertThat(s.pop()).isEqualTo("a");

        assertThatThrownBy(s::pop).isInstanceOf(RuntimeException.class).hasMessage(EMPTY_STACK_ERROR_MESSAGE);
    }
}