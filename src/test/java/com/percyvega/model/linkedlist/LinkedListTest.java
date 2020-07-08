package com.percyvega.model.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void of() {
        assertThat(LinkedList.of(4, 3, 12, 1, 0).toString()).isEqualTo("4 -> 3 -> 12 -> 1 -> 0");
        assertThat(LinkedList.of(3, 8, 1, 0).toString()).isEqualTo("3 -> 8 -> 1 -> 0");
        assertThat(LinkedList.of(3, 0).toString()).isEqualTo("3 -> 0");
        assertThat(LinkedList.of(3).toString()).isEqualTo("3");
    }

}