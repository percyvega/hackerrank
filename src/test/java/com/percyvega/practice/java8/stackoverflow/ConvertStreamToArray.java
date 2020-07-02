package com.percyvega.practice.java8.stackoverflow;

import com.percyvega.practice.java8.stackoverflow.model.Student;
import com.percyvega.practice.java8.stackoverflow.model.StudentsListSupplier;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertStreamToArray {

    @Test
    void stream_to_array() {
        List<Student> studentList = StudentsListSupplier.get();
        Stream<Student> studentStream = studentList.stream();

        Student[] studentArray = studentStream.toArray(Student[]::new);

        assertThat(Arrays.asList(studentArray)).isEqualTo(studentList);
    }

}
