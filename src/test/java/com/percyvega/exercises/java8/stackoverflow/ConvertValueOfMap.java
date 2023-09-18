package com.percyvega.exercises.java8.stackoverflow;

import com.percyvega.exercises.java8.stackoverflow.model.Student;
import com.percyvega.exercises.java8.stackoverflow.model.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ConvertValueOfMap {

    List<Student> studentList = StudentsListSupplier.get();
    Map<Integer, List<Student>> noteBooksStudentMap = studentList.stream().collect(Collectors.groupingBy(Student::getNoteBooks));
    Map<Integer, List<String>> noteBooksNameMap;

    @Test
    void convertValueOfMap() {
        noteBooksNameMap = noteBooksStudentMap.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                e -> e.getValue().stream().map(Student::getName).collect(Collectors.toList())
                        )
                );

        assertThat(noteBooksNameMap.get(12)).containsExactly("Ben Affleck", "Clint Eastwood");
    }

}
