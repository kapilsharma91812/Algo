package com.kapil.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kapilsharma on 17/07/17.
 */
public class BigSum {
    static void aVeryBigSum(int n, long[] arr) {
        // Complete this function
        List<Integer> sum = new ArrayList();
        for (int i =0; i < arr.length; i++) {
            add(sum, arr[i]);
        }
        for (int i = sum.size() -1; i >= 0; i--) {
            System.out.println(sum.get(i));
        }
    }
    private static void add(List<Integer> sum, long num) {
        int count = 0;
        int carry = 0;
        int newSum = 0;
        while (num > 0) {
            int rem = (int) num % 10;
            num = num / 10;
            if (sum.size() > count) {
                newSum = rem + carry + sum.get(count);
                carry = newSum / 10;
                sum.set(count, newSum % 10);
            } else {
                newSum = rem + carry;
                carry = newSum / 10;
                sum.add(newSum % 10);
            }
            count++;
        }
        if (carry > 0 && sum.size() > count) {
            for (int i = count; i < sum.size(); i++) {
                newSum = carry + sum.get(i);
                carry = newSum / 10;
                sum.set(i, newSum % 10);
            }
        }
        if (carry > 0){
            sum.add(carry);
        }


    }

    public static void main(String[] args) {
        long arr[] = new long[]{918, 123};
        aVeryBigSum(0, arr);
        //System.out.println(result);
    }
}
