package com.kapil.array.find;

/**
 * Created by kapilsharma on 16/07/17.
 */

/**
 * qs: you have given n numbers, all numbers are repeating except 2.
 * ex: 1,2,4,5,7,3,1,2,3,4 [5,7 non-repeating].
 * Solution: XOR of entire array : for same number XOR will be zero so you will get XOR of 5 and 7.
 * Now a xor b !=0 if a!=b. so xor will be non zero hence there will be at least one set bit , in this ex 5 xor 7 = 101 xor 111 =010
 * find this set bit. Now you found this set bit in xor of two numbers so this bit will present in either in a or b (like in above ex its in 7).
 * Now take two xor one for the numbers that have set bit and other that don't have this set bit.
 * In our example:
 * xor1=xor of {2,7,3,2,3} xor2= xor of {1,4,5,1,4} as we know all the elements are repeated except two and we now able to separate these two numbers, and same repeated number will be in same side because of same bit representation for ex {1,1} will always in same partition.
 * Now xor1 will be =7 because xor of same number will be zero. and by same logic xor2=5.
 */
public class TwoNonRepeating {
    public static void main(String[] args) {
        int arr[] = new int[]{2, 19, 3, 7, 11, 2, 3, 11, 9, 19};
        find(arr);
    }

    private static void find(int[] arr) {
        int x = 0;
        int y = 0;
        int res = 0;
        int ans =0;
        for (int a = 0; a < arr.length; a++) {
            res = res ^ arr[a];
        }
        ans = res & (~(res - 1));
        //printf("mid: %d", ans);
        for (int a = 0; a < 8; a++) {
            if ((arr[a] & ans) == ans) {
                x = x ^ arr[a];
            } else {
                y = y ^ arr[a];
            }
        }
        System.out.println("The non-repeating elements are " + x + "and " + y);
    }
}
