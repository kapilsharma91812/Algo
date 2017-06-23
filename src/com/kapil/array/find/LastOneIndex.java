package com.kapil.array.find;

/**
 * Created by kapilsharma on 21/06/17.
 */

/*
* Count 1’s in a sorted binary array
Given a binary array sorted in non-increasing order, count the number of 1’s in it.

Examples:

Input: arr[] = {1, 1, 0, 0, 0, 0, 0}
Output: 2

Input: arr[] = {1, 1, 1, 1, 1, 1, 1}
Output: 7

Input: arr[] = {0, 0, 0, 0, 0, 0, 0}
Output: 0
* */
public class LastOneIndex {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 1, 1, 1, 1, 1, 1};
        System.out.println(count(arr));
    }

    private static int count(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        return countUtil(arr, low, high);
    }

    private static int countUtil(int[] arr, int low, int high) {
        if (low > high) {
            return 0;
        } else {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                if ((mid == high) || arr[mid + 1] == 0) {
                    return mid;
                } else {
                    return countUtil(arr, mid + 1, high);
                }
            } else {
                return countUtil(arr, low, mid - 1);
            }
        }
    }
}
