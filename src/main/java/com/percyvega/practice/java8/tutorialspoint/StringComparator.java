package com.percyvega.practice.java8.tutorialspoint;

@FunctionalInterface
public interface StringComparator {

    int compare(String s1, String s2);

    default int defaultComparison(String s1, String s2) {
        return s1.length() - s2.length();
    }

    static String getName() {
        return "This is the name: " + getName();
    }

}
