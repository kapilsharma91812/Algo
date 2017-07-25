package com.kapil.greedy;


import java.util.Arrays;

/**
 * Created by kapilsharma on 25/07/17.
 */

/*
* Fractional Knapsack Problem
Given weights and values of n items, we need put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

In the 0-1 Knapsack problem, we are not allowed to break items. We either take the whole item or don’t take it.

Input:
  Items as (value, weight) pairs
  arr[] = {{60, 10}, {100, 20}, {120, 30}}
  Knapsack Capacity, W = 50;

  Output :
   Maximum possible value = 240
   By taking full items of 10 kg, 20 kg and
   2/3rd of last item of 30 kg
* */
public class FractionalKnapsack {

    private static class Knapsack implements Comparable<Knapsack>{
        int value;
        int weight;

        public Knapsack(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Knapsack obj) {
            int ratio1 = value / weight;
            int ratio2 = obj.value / obj.weight;
            return ratio2 - ratio1;
        }
    }

    public static void main(String[] args) {
        Knapsack arr[] = new Knapsack[3];
        arr[0] = new Knapsack(60, 10);
        arr[1] = new Knapsack(100, 20);
        arr[2] = new Knapsack(120, 30);
        Arrays.sort(arr);
        int value = getMaxValue(arr, 50);
        System.out.println(value);

    }

    private static int getMaxValue(Knapsack[] arr, int W) {
        int value = 0;
        for (int i = 0; i < arr.length && W > 0; i++) {
            if (arr[i].weight > W) {
                int ratio = arr[i].value / arr[i].weight;
                value = value + W * ratio;
                W = 0;

            } else {
                value = value + arr[i].value;
                W = W - arr[i].weight;
            }
        }
            return value;
    }
}
