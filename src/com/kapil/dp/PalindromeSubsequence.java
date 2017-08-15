package com.kapil.dp;

/**
 * Created by kapilsharma on 15/08/17.
 */
public class PalindromeSubsequence {

    public static void main(String[] args) {
        String str = "niin";
        System.out.println("len:" + getLen(str));
    }

    private static int getLen(String str) {
        int arr[][] = new int[str.length()][str.length()];
        for (int currentlen = 0; currentlen < str.length(); currentlen++) {
            int row = 0;
            int col = currentlen;
            while (col < str.length()) {
                if (row == col) {
                    arr[row][col] = 1;
                }else if(str.charAt(row) == str.charAt(col) && row +1 == col) {
                    arr[row][col] = 2;
                } else if(str.charAt(row) == str.charAt(col)) {
                    arr[row][col] = 2 + Math.max(arr[row ][col - 1], arr[row+ 1][col]);
                } else {
                    arr[row][col] =  Math.max(arr[row ][col - 1], arr[row+ 1][col]);
                }
                row ++;
                col ++;
            }
        }
        return arr[0][arr.length - 1];
    }
}
