package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.linkedlist.LinkedList;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ReverseALinkedList {

    @Test
    void isValidTest() {
        assertThat(reverse(LinkedList.of(4, 3, 12, 1, 0)).toString()).isEqualTo("0 -> 1 -> 12 -> 3 -> 4");
        assertThat(reverse(LinkedList.of(3, 8, 1, 0)).toString()).isEqualTo("0 -> 1 -> 8 -> 3");
        assertThat(reverse(LinkedList.of(3, 0)).toString()).isEqualTo("0 -> 3");
        assertThat(reverse(LinkedList.of(3)).toString()).isEqualTo("3");
    }

    private <E> LinkedList<E> reverse(LinkedList<E> node) {
        LinkedList<E> nextNode = node.next;

        if (nextNode == null) {
            return node;
        }

        while (nextNode.next != null && !nextNode.next.isReversed) {
            nextNode = nextNode.next;
        }

        if (!nextNode.isReversed) {
            E data1 = node.value;
            E data2 = nextNode.value;
            nextNode.value = data1;
            nextNode.isReversed = true;
            node.value = data2;
            node.isReversed = true;

            reverse(node.next);
        }

        return node;
    }

}