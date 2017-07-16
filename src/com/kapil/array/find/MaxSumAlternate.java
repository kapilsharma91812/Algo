package com.kapil.array.find;

/**
 * Created by kapilsharma on 16/07/17.
 */

 /*Function to return max sum such that no two elements
      are adjacent */

public class MaxSumAlternate
{


    //Formula tmp = max(old excl + new Item, incl)
    private static void findAltSum(int arr[]) {
        int exc = 0;
        int inc = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int tmp = Math.max(exc + arr[i], inc);
            exc = inc;
            inc = tmp;
        }
        System.out.println("Output:" + inc);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        MaxSumAlternate sum = new MaxSumAlternate();
        //int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        //int arr[] = new int[]{30, 18, 20, 48, 19, 21, 2};
        //int arr[] = new int[]{4,1,1,4,2,1};
        int arr[] = new int[]{1, 20, 3};
        findAltSum(arr);
        //System.out.println(sum.FindMaxSum(arr, arr.length));
    }
}
