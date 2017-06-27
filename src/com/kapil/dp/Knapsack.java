package com.kapil.dp;

/**
 * Created by kapilsharma on 25/06/17.
 */
public class Knapsack {
    public static void main(String[] args) {
        int val[] = {1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        System.out.println("Max Value:" + bottomUpDP(val, wt, 7));
    }

    public static int bottomUpDP(int val[], int wt[], int W) {
        int K[][] = new int[val.length + 1][W + 1];
        for (int v = 0; v <= val.length; v++) {
            for (int w = 0; w <= W; w++) {
                if (v == 0 || w == 0) {
                    K[v][w] = 0;
                    continue;
                }
                if (w - wt[v - 1] >= 0) {
                    K[v][w] = Math.max(K[v - 1][w], K[v - 1][w - wt[v - 1]] + val[v - 1]);
                } else {
                    K[v][w] = K[v - 1][w];
                }
            }
        }
        return K[val.length][W];
    }
}
