package com.percyvega.practice.java8.stackoverflow;

import com.percyvega.practice.java8.stackoverflow.model.Student;
import com.percyvega.practice.java8.stackoverflow.model.StudentsListSupplier;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertListToMap {

    List<Student> studentList = StudentsListSupplier.get();

    @Test
    void mapFromList_using_toMap() {
        Map<String, Student> studentMap = studentList.stream()
                .collect(Collectors.toMap(Student::getName, s -> s));

        assertThat(studentMap.get("Matt Damon").getGpa()).isEqualTo(3.6);
        assertThat(studentMap.get("Johnny Depp").getNoteBooks()).isEqualTo(11);
    }

    @Test
    void mapFromList_using_toMap_and_functionIdentity() {
        Map<String, Student> studentMap = studentList.stream()
                .collect(Collectors.toMap(Student::getName, Function.identity()));

        assertThat(studentMap.get("Matt Damon").getGpa()).isEqualTo(3.6);
        assertThat(studentMap.get("Johnny Depp").getNoteBooks()).isEqualTo(11);
    }

}
