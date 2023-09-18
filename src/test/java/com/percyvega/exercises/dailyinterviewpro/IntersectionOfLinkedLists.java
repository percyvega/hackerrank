package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.linkedlist.LinkedList;
import com.percyvega.model.linkedlist.LinkedListNode;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class IntersectionOfLinkedLists {

    @Test
    void isValidTest() {
        assertThat(findIntersectionNodeValue(LinkedList.of(1, 2, 3, 4), LinkedList.of(6, 3, 4))).isEqualTo(3);
        assertThat(findIntersectionNodeValue(LinkedList.of(3, 4), LinkedList.of(6, 3, 4))).isEqualTo(3);
        assertThat(findIntersectionNodeValue(LinkedList.of(3), LinkedList.of(6, 3, 4))).isEqualTo(3);
        assertThat(findIntersectionNodeValue(LinkedList.of(4), LinkedList.of(6, 3, 4))).isEqualTo(4);
        assertThat(findIntersectionNodeValue(LinkedList.of(4), LinkedList.of(3, 4))).isEqualTo(4);
        assertThat(findIntersectionNodeValue(LinkedList.of(4), LinkedList.of(4))).isEqualTo(4);
        assertThat(findIntersectionNodeValue(LinkedList.of(1, 2, 3, 4, 5, 6, 7), LinkedList.of(3, 4, 5, 6, 7))).isEqualTo(3);
    }

    private int findIntersectionNodeValue(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> node1 = head1;
        LinkedListNode<Integer> node2 = head2;

        while (!node1.data.equals(node2.data)) {
            if (node2.next != null) {
                node2 = node2.next;
            } else {
                node1 = node1.next;
                node2 = head2;
            }
        }
        return node1.data;
    }

}
