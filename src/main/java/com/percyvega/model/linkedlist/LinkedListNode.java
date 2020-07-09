package com.percyvega.model.linkedlist;

public class LinkedListNode<E> {
    public E data;
    public LinkedListNode<E> next;
    public boolean isReversed = false;

    public LinkedListNode(E data) {
        this.data = data;
    }

    LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        LinkedListNode<E> node = this;
        while (node != null) {
            s.append(node.data);
            node = node.next;
            if (node != null) {
                s.append(" -> ");
            }
        }

        return s.toString();
    }
}
