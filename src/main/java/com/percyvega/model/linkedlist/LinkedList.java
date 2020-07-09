package com.percyvega.model.linkedlist;

public abstract class LinkedList {

    @SafeVarargs
    public static <E> LinkedListNode<E> of(E... dataArray) {
        return of(dataArray, 0);
    }

    private static <E> LinkedListNode<E> of(E[] dataArray, int dataIndex) {
        if (dataArray.length <= dataIndex) {
            return null;
        } else {
            E data = dataArray[dataIndex];
            return new LinkedListNode<>(data, of(dataArray, ++dataIndex));
        }
    }

}
