package com.kapil.practice;

/**
 * Created by kapilsharma on 29/11/17.
 */
public class Pivoted {

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println(getIndex(arr, key, 0, arr.length -1));
    }

    private static int getIndex(int[] arr, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (arr[mid] == key) {
            return mid;
        }
        if (arr[start] < arr[mid]) { //sorted

            if (key >= arr[start] && key < arr[mid]) {
                return getIndex(arr, key, start, mid -1);
            } else {
                return getIndex(arr, key, mid + 1, end);
            }

        }

        if (key >= arr[mid] && key <= arr[end]) {
            return getIndex(arr, key, mid + 1, end);
        } else {
            return getIndex(arr, key, start, mid -1);
        }

    }
}
