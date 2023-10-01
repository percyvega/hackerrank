package com.percyvega.exercises.algox.easy;

import com.percyvega.model.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MiddleNodeTest {

    // Time: O(n): where n is the number of nodes.
    // Space: O(1)
    public LinkedList<Integer> middleNode(LinkedList<Integer> linkedList) {
        int size = 0;

        LinkedList<Integer> node = linkedList;

        while(node != null) {
            size++;
            node = node.next;
        }

        int i = 0;
        node = linkedList;
        while(i < size / 2) {
            node = node.next;
            i++;
        }

        return node;
    }

    @Test
    void testMiddleNode() {
        assertThat(middleNode(LinkedList.of(2)).value).isEqualTo(2);
        assertThat(middleNode(LinkedList.of(2, 7)).value).isEqualTo(7);
        assertThat(middleNode(LinkedList.of(2, 7, 3, 5)).value).isEqualTo(3);
        assertThat(middleNode(LinkedList.of(2, 7, 3, 5, 6)).value).isEqualTo(3);
        assertThat(middleNode(LinkedList.of(2, 7, 3, 5, 6, 8)).value).isEqualTo(5);
    }

}
