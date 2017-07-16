package com.kapil.array.find;

/**
 * Created by kapilsharma on 16/07/17.
 */

//Find the number of times a sorted array has been rotated.
  /*   {7, 9, 11, 12, 5}
            {15, 18, 2, 3, 6, 12}
            {7, 9, 11, 12, 15};
            */
public class FindRotation {
    public static void main(String[] args) {
        int arr[] = new int[] {6,7,8,1,2,3,4,5};
        System.out.println(findRotation(arr));
    }

    private static int findRotation(int[] arr) {
        return findRotationUtil(arr, 0, arr.length - 1);
    }

    private static int findRotationUtil(int[] arr, int start, int end) {
        int mid = (start + end ) / 2;
        if (mid == 0 && arr[mid] > arr[mid + 1]) {
            return mid;
        }

        if (mid == end) {
            if (arr[mid] < arr[mid - 1]) {
                return mid;
            } else {
                return -1;
            }
        }

        if (arr[mid] < arr[mid -1] && arr[mid] < arr[mid +1]) {
            return mid;
        }

        if (arr[start] > arr[mid] ) {
          return findRotationUtil(arr, start, mid - 1);
        } else {
            return findRotationUtil(arr, mid + 1, end);
        }

    }
}
