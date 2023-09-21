package com.percyvega.model.graph;

import java.util.Arrays;
import java.util.List;

public class Graph<E> {

    public E value;
    public List<Graph<E>> children;

    public static <E> Graph<E> of(E value) {
        Graph<E> graph = new Graph<>();
        graph.value = value;

        return graph;
    }

    @SafeVarargs
    public static <E> Graph<E> of(E value, E... childrenValues) {
        Graph<E> graph = of(value);
        graph.children = Arrays.stream(childrenValues)
                .map(Graph::of)
                .toList();

        return graph;
    }

    @SafeVarargs
    public static <E> Graph<E> of(E value, Graph<E>... children) {
        Graph<E> graph = of(value);
        graph.children = Arrays.stream(children)
                .toList();

        return graph;
    }

}
