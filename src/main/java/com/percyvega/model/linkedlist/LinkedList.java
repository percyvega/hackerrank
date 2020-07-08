package com.percyvega.model.linkedlist;

public class LinkedList {

    @SafeVarargs
    public static <T> LinkedListNode<T> of(T... dataArray) {
        return of(dataArray, 0);
    }

    private static <T> LinkedListNode<T> of(T[] dataArray, int dataIndex) {
        if (dataArray.length <= dataIndex) {
            return null;
        } else {
            T data = dataArray[dataIndex];
            return new LinkedListNode<>(data, of(dataArray, ++dataIndex));
        }
    }

}
