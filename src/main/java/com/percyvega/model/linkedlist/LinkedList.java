package com.percyvega.model.linkedlist;

import java.util.Objects;

public class LinkedList<E> {
    public E value;
    public LinkedList<E> next;
    public boolean isReversed = false;

    public LinkedList(E value) {
        this(value, null);
    }

    private LinkedList(E value, LinkedList<E> next) {
        this.value = value;
        this.next = next;
    }

    @SafeVarargs
    public static <E> LinkedList<E> of(E... dataArray) {
        return of(dataArray, 0);
    }

    private static <E> LinkedList<E> of(E[] dataArray, int dataIndex) {
        if (dataArray.length <= dataIndex) {
            return null;
        } else {
            E data = dataArray[dataIndex];
            return new LinkedList<>(data, of(dataArray, ++dataIndex));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedList<?> that = (LinkedList<?>) o;

        if (isReversed != that.isReversed) return false;
        if (!Objects.equals(value, that.value)) return false;
        return Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + (isReversed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        LinkedList<E> node = this;
        while (node != null) {
            s.append(node.value);
            node = node.next;
            if (node != null) {
                s.append(" -> ");
            }
        }

        return s.toString();
    }
}
