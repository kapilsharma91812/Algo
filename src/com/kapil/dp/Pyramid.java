package com.kapil.dp;

/**
 * Created by kapilsharma on 16/08/17.
 */
public class Pyramid {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 3, 4, 2, 1};
      //  int arr[] = new int[] {1, 5, 2};
        System.out.println(minPyramidCost(arr, arr.length));
    }

    static int minPyramidCost(int arr[], int N)
    {
        // Store the maximum possible pyramid height
        int left[] = new int[N];
        int right[] = new int[N];
        // Maximum height at start is 1
        left[0] = Math.min(arr[0], 1);

        // For each position calculate maximum height
        for (int i = 1; i < N; ++i)
            left[i] = Math.min(arr[i],
                    Math.min(left[i - 1] + 1, i + 1));

        // Maximum height at end is 1
        right[N - 1] = Math.min(arr[N - 1], 1);

        // For each position calculate maximum height
        for (int i = N - 2; i >= 0; --i)
            right[i] = Math.min(arr[i],
                    Math.min(right[i + 1] + 1, N - i));

        // Find Math.minimum possible among calculated values
        int tot[] = new int[N];
        for (int i = 0; i < N; ++i)
            tot[i] = Math.min(right[i], left[i]);

        // Find maximum height of pyramid
        int max_ind = 0;
        for (int i = 0; i < N; ++i)
            if (tot[i] > tot[max_ind])
                max_ind = i;

        // Calculate cost of this pyramid
        int cost = 0;
        int height = tot[max_ind];

        // Calculate cost of left half
        for (int x = max_ind; x >= 0; --x)
        {
            cost += arr[x] - height;
            if (height > 0)
                --height;
        }

        // Calculate cost of right half
        height = tot[max_ind] - 1;
        for (int x = max_ind + 1; x < N; ++x)
        {
            cost += arr[x] - height;
            if (height > 0)
                --height;
        }
        return cost;
    }
}
