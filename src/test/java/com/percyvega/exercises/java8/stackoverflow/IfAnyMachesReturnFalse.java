package com.percyvega.exercises.java8.stackoverflow;

import com.percyvega.exercises.java8.stackoverflow.model.Student;
import com.percyvega.exercises.java8.stackoverflow.model.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * If specified date already exists in some task it returns false, otherwise true
 */
@Log4j2
public class IfAnyMachesReturnFalse {

    static List<Student> studentList = StudentsListSupplier.get();

    @Test
    void when_it_does_not_exist() {
        Optional<Student> optionalStudent = studentList.stream()
                .filter(student -> student.getNoteBooks() == 13)
                .findFirst();

        assertThat(optionalStudent).isNotPresent();
    }

    @Test
    void when_it_does_exist() {
        Optional<Student> optionalStudent = studentList.stream()
                .filter(student -> student.getNoteBooks() == 12)
                .findFirst();

        assertThat(optionalStudent).isPresent();
    }
}
