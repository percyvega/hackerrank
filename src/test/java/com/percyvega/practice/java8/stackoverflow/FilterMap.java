package com.percyvega.practice.java8.stackoverflow;

import com.percyvega.practice.java8.stackoverflow.model.Student;
import com.percyvega.practice.java8.stackoverflow.model.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FilterMap {

    List<Student> studentList = StudentsListSupplier.get();
    Map<Integer, List<Student>> noteBooksStudentMap = studentList.stream()
            .collect(Collectors.groupingBy(Student::getNoteBooks));

    @Test
    void mapFromList_using_toMap() {
        assertThat(studentList).hasSize(15);
        assertThat(noteBooksStudentMap).hasSize(5);

        Map<Integer, List<Student>> filteredMap = noteBooksStudentMap.entrySet().stream()
                .filter(integerListEntry -> integerListEntry.getKey() >= 12)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        assertThat(filteredMap).hasSize(3);
    }

}
