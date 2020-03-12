package com.percyvega.practice.java8.tutorialspoint;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StringComparatorY implements StringComparator {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }

}
