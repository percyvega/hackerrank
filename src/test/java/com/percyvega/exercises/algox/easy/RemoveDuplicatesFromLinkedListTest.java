package com.percyvega.exercises.algox.easy;

import com.percyvega.model.linkedlist.LinkedList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromLinkedListTest {

    // Time: O(n) time, where n is the number of nodes in the list.
    // Space: O(1) space
    public LinkedList<Integer> removeDuplicatesFromLinkedList(LinkedList<Integer> linkedList) {
        LinkedList<Integer> head = linkedList;

        while (head != null) {
            Integer data = head.value;
            LinkedList<Integer> next = head.next;

            if(next != null) {
                if (data.equals(next.value)) {
                    head.next = head.next.next;
                } else {
                    head = next;
                }
            } else {
                break;
            }
        }

        return linkedList;
    }

    @Test
    void removeDuplicatesFromLinkedListTest() {
        LinkedList<Integer> linkedList = LinkedList.of(1, 1, 3, 4, 4, 4, 5, 6, 6);

        assertThat(removeDuplicatesFromLinkedList(linkedList)).isEqualTo(LinkedList.of(1, 3, 4, 5, 6));
    }

}
