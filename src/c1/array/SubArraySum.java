package c1.array;

import java.util.ArrayList;

public class SubArraySum {
    public static class SequenceSum {
        public boolean hasSequenceSum(int[] arr, int k) {
            if (k <= 0) {
                return false;
            }
            int left = 0;
            int right = 0;
            int sum = arr[0];
            while (right < arr.length) {
                if (sum == k) {
                    return true;
                } else if (sum < k) {
                    right++;
                    if (right < arr.length) {
                        sum += arr[right];
                    }
                } else {
                    sum -= arr[left];
                    left++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SequenceSum ss = new SequenceSum();
        System.out.println(ss.hasSequenceSum(new int[]{1, 1, 1, 1, 1, 100, 10, 10}, 20));
        System.out.println(ss.hasSequenceSum(new int[]{2, 2, 3, 100, 10, 10}, 1));
        System.out.println(ss.hasSequenceSum(new int[]{3, 5, 7, 9, 11, 13}, 27));
    }
}


