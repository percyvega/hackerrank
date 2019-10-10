package com.percyvega.hackerrank.interview_preparation_kit.warm_up;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int[] ar) {
        List<Integer> alreadyPaired = new ArrayList<>();
        int countPaired = 0;

        for (int i = 0; i < ar.length - 1; i++) {
            if (!alreadyPaired.contains(i)) {
                for (int j = i + 1; j < ar.length; j++) {
                    if (!alreadyPaired.contains(j)) {
                        if (ar[i] == ar[j]) {
                            alreadyPaired.add(i);
                            alreadyPaired.add(j);

                            countPaired++;
                            break;
                        }
                    }
                }
            }
        }

        return countPaired;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int result = sockMerchant(new int[]{10, 20, 40, 20, 10, 40, 10, 30, 50, 90, 10, 20, 90});

        log.info(result);

        scanner.close();
    }
}
