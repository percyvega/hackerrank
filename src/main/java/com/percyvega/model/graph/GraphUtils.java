package com.percyvega.model.graph;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphUtils {

    public static <E> List<E> depthFirstSearch(@NonNull Graph<E> node) {
        List<E> list = new ArrayList<>(List.of(node.value));

        if (node.children != null) {
            for (Graph<E> child : node.children) {
                list.addAll(depthFirstSearch(child));
            }
        }

        return list;
    }

}
