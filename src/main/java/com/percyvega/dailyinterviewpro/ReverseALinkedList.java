package com.percyvega.dailyinterviewpro;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ReverseALinkedList {

    @Test
    void isValidTest() {
        assertThat(reverse(produceTreeHead(4, 3, 12, 1, 0)).toString()).isEqualTo("0 -> 1 -> 12 -> 3 -> 4");
        assertThat(reverse(produceTreeHead(3, 8, 1, 0)).toString()).isEqualTo("0 -> 1 -> 8 -> 3");
        assertThat(reverse(produceTreeHead(3, 0)).toString()).isEqualTo("0 -> 3");
        assertThat(reverse(produceTreeHead(3)).toString()).isEqualTo("3");
    }

    private <T> Node<T> reverse(Node<T> node) {
        Node<T> nextNode = node.next;

        if(nextNode == null) {
            return node;
        }

        while (nextNode.next != null && !nextNode.next.isReversed) {
            nextNode = nextNode.next;
        }

        if(!nextNode.isReversed) {
            T data1 = node.data;
            T data2 = nextNode.data;
            nextNode.data = data1;
            nextNode.isReversed = true;
            node.data = data2;
            node.isReversed = true;

            reverse(node.next);
        }

        return node;
    }

    static <T> Node<T> produceTreeHead(T... dataArray) {
        return produceTreeHead(dataArray, 0);
    }

    static <T> Node<T> produceTreeHead(T[] dataArray, int dataIndex) {
        if (dataArray.length <= dataIndex) {
            return null;
        } else {
            T data = dataArray[dataIndex];
            return new Node<>(data, produceTreeHead(dataArray, ++dataIndex));
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;
    boolean isReversed = false;

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node<T> node = this;
        while (node != null) {
            s.append(node.data);
            node = node.next;
            if(node != null) {
                s.append(" -> ");
            }
        }

        return s.toString();
    }
}