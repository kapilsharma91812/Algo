package com.kapil.dp;

/**
 * Created by kapilsharma on 15/08/17.
 */
public class PaperCut {
    static int dp[][];
    private static int minimumSquare(int m, int n)
    {
       // System.out.println("try for " + m + " and " + n);
        // Initializing max values to vertical_min
        // and horizontal_min
        int vertical_min = Integer.MAX_VALUE;
        int horizontal_min = Integer.MAX_VALUE;

        // If the given rectangle is already a square
        if (m == n)
            return 1;

        // If the answer for the given rectangle is
        // previously calculated return that answer
        if (dp[m][n] != 0) {
            //System.out.println("Already calculated: " + dp[m][n]);
            return dp[m][n];
        }

    /* The rectangle is cut horizontally and
       vertically into two parts and the cut
       with minimum value is found for every
       recursive call.
    */

        for (int i = 1;i<= m/2;i++)
        {
            // Calculating the minimum answer for the
            // rectangles with width equal to n and length
            // less than m for finding the cut point for
            // the minimum answer
            horizontal_min = Math.min(minimumSquare(i, n) +
                    minimumSquare(m-i, n), horizontal_min);
        }

        for (int j = 1;j<= n/2;j++)
        {
            // Calculating the minimum answer for the
            // rectangles with width less than n and
            // length equal to m for finding the cut
            // point for the minimum answer
            vertical_min = Math.min(minimumSquare(m, j) +
                    minimumSquare(m, n-j), vertical_min);
        }

        // Minimum of the vertical cut or horizontal
        // cut to form a square is the answer
        dp[m][n] = Math.min(vertical_min, horizontal_min);

        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 5, n = 4;
        dp  = new int[m + 1][n + 1];
        System.out.println(minimumSquare(m, n));
    }

}
