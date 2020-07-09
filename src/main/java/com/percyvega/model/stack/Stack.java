package com.percyvega.model.stack;

public class Stack<E> {

    public static final int MAX_SIZE = 1000;
    public static final String EMPTY_STACK_ERROR_MESSAGE = "You cannot pop from an empty stack.";
    public static final String STACK_MAXIMUM_CAPACITY_ERROR_MESSAGE = "Stack maximum capacity has been reached.";

    private E[] array = (E[]) new Object[MAX_SIZE];
    private int size = 0;

    public static <E> Stack<E> of(E... elements) {
        return new Stack<E>().push(elements);
    }

    public Stack<E> push(E... elements) {
        for (E e : elements) {
            push(e);
        }

        return this;
    }

    public Stack<E> push(E element) {
        if (size == MAX_SIZE) {
            throw new RuntimeException(STACK_MAXIMUM_CAPACITY_ERROR_MESSAGE);
        }
        array[size++] = element;

        return this;
    }

    public E pop() {
        if (size == 0) {
            throw new RuntimeException(EMPTY_STACK_ERROR_MESSAGE);
        }
        return array[--size];
    }

    public int size() {
        return size;
    }

}
