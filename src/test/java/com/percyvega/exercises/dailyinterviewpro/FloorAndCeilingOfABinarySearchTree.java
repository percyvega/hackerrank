package com.percyvega.exercises.dailyinterviewpro;

import com.percyvega.model.BTreePrinter;
import com.percyvega.model.Node;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class FloorAndCeilingOfABinarySearchTree {

    Node<Integer> rootNode;

    @BeforeEach
    void setUp() {
        rootNode = Node.of(8, 4, 12, 2, 6, 10, 14);
        BTreePrinter.printNode(rootNode);
    }

    @Test
    void testThis() {
//        assertThat(findCeilingAndFloor(rootNode, 5)).containsExactly(4, 6);
    }

    private <T> List<Integer> findCeilingAndFloor(Node<T> node, int target) {
        List<Integer> celingAndFloor = new ArrayList<>(2);

//        while(true) {
//            Integer value = node.value;
//            if(value == target) {
//                break;
//            } else {
//                if(value)
//            }
//        }

        return celingAndFloor;
    }

}
