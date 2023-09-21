package com.percyvega.model.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphUtilsTest {

    @Test
    void testDepthFirstSearch() {
        Graph<String> graph = Graph.of(
                "A",
                Graph.of(
                        "B",
                        Graph.of("E"),
                        Graph.of("F", "I", "J")
                ),
                Graph.of("C"),
                Graph.of(
                        "D",
                        Graph.of("G", "K"),
                        Graph.of("H")
                )
        );

        assertThat(GraphUtils.depthFirstSearch(graph))
                .containsExactly("A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H");
    }

}