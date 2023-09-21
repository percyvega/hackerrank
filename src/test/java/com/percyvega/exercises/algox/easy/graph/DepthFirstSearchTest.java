package com.percyvega.exercises.algox.easy.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthFirstSearchTest {
    // O(v + e) time | O(v) space - where v is the number of vertex in the graph, and e is the number of edges.

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public static Node of(String name, Node... children) {
            Node node = new Node(name);
            node.children.addAll(Arrays.asList(children));

            return node;
        }

        public List<String> depthFirstSearch(List<String> names) {
            names.add(name);

            for (Node child : children) {
                child.depthFirstSearch(names);
            }

            return names;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    @Test
    void testDepthFirstSearch() {
        Node node = Node.of(
                "A",
                Node.of(
                        "B",
                        Node.of("E"),
                        Node.of("F", new Node("I"), new Node("J")
                        ),
                        Node.of("C"),
                        Node.of(
                                "D",
                                Node.of("G", new Node("K")),
                                Node.of("H")
                        )
                )
        );

        assertThat(node.depthFirstSearch(new ArrayList<>()))
                .containsExactly("A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H");
    }

}
