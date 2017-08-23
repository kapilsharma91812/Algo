package com.kapil.dp;

/**
 * Created by kapilsharma on 15/08/17.
 */
// Java program to find Non-decreasing sequence
// of size k with minimum sum
import java.io.*;
import java.util.*;

public class NonDecreasingSeq
{
    public static int MAX = 100;
    public static int inf = 1000000;

    // Table used for memoization
    public static int[][] dp = new int[MAX][MAX];

    // intialize
    static void initialize()
    {
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                dp[i][j] = -1;
    }

    // Function to find non-decreasing sequence
    // of size k with minimum sum
    static int solve(int arr[], int len, int k)
    {
        // If already computed
        if (dp[len][k] != -1)
            return dp[len][k];

        // Corner cases
        if (len < 0)
            return inf;
        if (k == 1)
        {
            int ans = inf;
            for (int j = 0; j <= len; j++)
                ans = Math.min(ans, arr[len]);
            return ans;
        }

        // Recursive computation
        int ans = inf;
        for (int j = 0; j < len; j++)
            if (arr[len] >= arr[j])
                ans = Math.min(ans, Math.min(solve(arr, j, k), solve(arr, j, k - 1) + arr[len]));
            else
                ans = Math.min(ans, solve(arr, j, k));

        dp[len][k] = ans;

        return dp[len][k];
    }

    // driver program
    public static void main (String[] args)
    {
        initialize();
        int a[] = { 58, 12, 11, 12, 82, 30,
                20, 77, 16, 86 };
        int n = a.length;
        int k = 4;
        System.out.println(solve(a, n - 1, k));
    }
}
