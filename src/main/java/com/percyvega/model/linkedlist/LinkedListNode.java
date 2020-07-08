package com.percyvega.model.linkedlist;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    public boolean isReversed = false;

    public LinkedListNode(T data) {
        this.data = data;
    }

    LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        LinkedListNode<T> node = this;
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
