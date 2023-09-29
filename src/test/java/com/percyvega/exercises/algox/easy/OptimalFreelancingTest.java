package com.percyvega.exercises.algox.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OptimalFreelancingTest {

    // Time: O(n log (n)) time, because of the sorting algorithm.
    // Space: O(1) space, because the array we create is of size 7.
    private static final String DEADLINE = "deadline";
    private static final String PAYMENT = "payment";

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        int totalSalary = 0;

        Arrays.sort(jobs, (o1, o2) -> o2.get(PAYMENT) - o1.get(PAYMENT));

        boolean[] isDayBusy = new boolean[7];
        for (Map<String, Integer> job : jobs) {
            int deadline = job.get(DEADLINE);
            for (int day = Math.min(7, deadline); day >= 1; day--) {
                if (!isDayBusy[day - 1]) {
                    isDayBusy[day - 1] = true;
                    totalSalary += job.get(PAYMENT);
                    break;
                }
            }
        }

        return totalSalary;
    }

    @Test
    void testOptimalFreelancing0() {
        assertThat(optimalFreelancing(getDeadlinePaymentMapArray(1, 1))).isEqualTo(1);
        assertThat(optimalFreelancing(getDeadlinePaymentMapArray(1, 4))).isEqualTo(4);
        assertThat(optimalFreelancing(getDeadlinePaymentMapArray(2, 4))).isEqualTo(4);
        assertThat(optimalFreelancing(getDeadlinePaymentMapArray(1, 3, 2, 4))).isEqualTo(7);
        assertThat(optimalFreelancing(getDeadlinePaymentMapArray(1, 3, 2, 4, 2, 5))).isEqualTo(9);
    }

    @SuppressWarnings("unchecked")
    private Map<String, Integer>[] getDeadlinePaymentMapArray(int... deadlinesPayments) {
        Map<String, Integer>[] jobs = (Map<String, Integer>[]) new LinkedHashMap[deadlinesPayments.length / 2];

        for (int i = 0; i < deadlinesPayments.length; i += 2) {
            jobs[i / 2] = new LinkedHashMap<>(Map.of(DEADLINE, deadlinesPayments[i], PAYMENT, deadlinesPayments[i + 1]));
        }

        return jobs;
    }

    // bubble sort to sort incrementally by deadline
    private void sortDecrementallyByPayment(Map<String, Integer>[] jobs) {
        for (int i = 0; i < jobs.length - 1; i++) {
            for (int j = i + 1; j < jobs.length; j++) {
                Map<String, Integer> iElement = jobs[i];
                Map<String, Integer> jElement = jobs[j];
                if (iElement.get(DEADLINE) > jElement.get(DEADLINE)) {
                    jobs[i] = jElement;
                    jobs[j] = iElement;
                }
            }
        }
    }

    // bubble sort to also (secondary) sort decrementally by payment
//        for (int i = 0; i < jobs.length - 1; i++) {
//            for (int j = i + 1; j < jobs.length; j++) {
//                Map<String, Integer> iElement = jobs[i];
//                Map<String, Integer> jElement = jobs[j];
//                if (iElement.get(DEADLINE).equals(jElement.get(DEADLINE))) {
//                    if (iElement.get(PAYMENT) < jElement.get(PAYMENT)) {
//                        jobs[i] = jElement;
//                        jobs[j] = iElement;
//                    }
//                } else {
//                    i = j - 1;
//                    break;
//                }
//            }
//        }

//        int idxJob = 0;
//        int totalSalary = 0;
//        for (int day = 1; day <= 7; day++) {
//            while (idxJob < jobs.length) {
//                int deadline = jobs[idxJob].get(DEADLINE);
//                int payment = jobs[idxJob].get(PAYMENT);
//
//                idxJob++;
//
//                if (day <= deadline) {
//                    totalSalary += payment;
//                    break;
//                }
//            }
//        }
//
//        return totalSalary;
}
