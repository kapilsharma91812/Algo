package com.kapil.array.find;

/**
 * Created by kapilsharma on 15/08/17.
 */
public class FindSumSubArray {
    public static void main(String[] args) {
        int arr[] = new int[]{1,4,20,3,10,5};
        int sum = 33;
        find(arr, sum);
    }

    private static void find(int[] arr, int sum) {
        int start, end, currentSum;
        start = 0;
        end = -1;
        currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (currentSum == sum) {
                break;
            }
            end++;
            currentSum = currentSum + arr[end];
            if(currentSum > sum) {
                while(start <= end) {
                    currentSum = currentSum - arr[start];
                    start++;
                    if (currentSum <= sum ) {
                        break;
                    }
                }
            }
        }
        if (currentSum == sum) {
            for (int i = start; i <= end; i++) {
                System.out.println(arr[i]);
            }
        }
    }

}
