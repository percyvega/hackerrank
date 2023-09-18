package com.percyvega.exercises.java8.stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ConvertTypesTest {

    static List<ObjectA> objectAList = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        objectAList.add(new ObjectA("Salary", "Bonuses", "Primary", 10000.0, 2000.0, 3500.0));
        objectAList.add(new ObjectA("Salary", "Taxes", "Secondary", 11000.0, 2100.0, 3600.0));
        objectAList.add(new ObjectA("Budget", "Monthly", "Food", 10000.0, 2000.0, 3500.0));
        objectAList.add(new ObjectA("Budget", "Weekly", "Entertainment", 11000.0, 2100.0, 3600.0));
        objectAList.add(new ObjectA("Bank", "Checking", "Primary", 200.0, 250.0, 320.0));
    }

    @Test
    void convert() {
        Map<String, ObjectB> collect = objectAList.stream()
                .map(ObjectB::fromObjectA)
                .collect(
                        Collectors.toMap(
                                ObjectB::getField1,
                                Function.identity(),
                                (b1, b2) -> new ObjectB(
                                        b1.getField1(),
                                        b1.getValue1() + b2.getValue1(),
                                        b1.getValue2() + b2.getValue2(),
                                        b1.getValue3() + b2.getValue3()
                                )
                        )
                );

        assertThat(collect).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        "Salary", new ObjectB("Salary", 21000, 4100, 7100),
                        "Budget", new ObjectB("Budget", 21000, 4100, 7100),
                        "Bank", new ObjectB("Bank", 200, 250, 320)
                )
        );
    }

}

@Data
@AllArgsConstructor
class ObjectA {
    private String field1, field2, field3;
    private double value1, value2, value3;
}

@Data
@AllArgsConstructor
class ObjectB {
    private String field1;
    private double value1, value2, value3;

    public static ObjectB fromObjectA(ObjectA objectA) {
        return new ObjectB(objectA.getField1(), objectA.getValue1(), objectA.getValue2(), objectA.getValue3());
    }
}
