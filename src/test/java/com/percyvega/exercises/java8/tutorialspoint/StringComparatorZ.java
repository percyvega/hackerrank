package com.percyvega.exercises.java8.tutorialspoint;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StringComparatorZ implements StringComparator {

    @Override
    public int compare(String s1, String s2) {
        return StringComparator.super.defaultComparison(s1, s2);
    }

}
