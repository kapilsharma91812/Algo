package com.kapil.array.find;

/**
 * Created by kapilsharma on 25/06/17.
 */
public class MinMax {

    class Pair {
        int min;
        int max;
    }

    ;

    private Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;  
 
  /* If array has even number of elements then 
    initialize the first two elements as minimum and 
    maximum */
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;  /* set the startung index for loop */
        }  
 
   /* If array has odd number of elements then 
    initialize the first element as minimum and 
    maximum */
        else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;  /* set the startung index for loop */
        }
   
  /* In the while loop, pick elements in Pair and 
     compare the Pair with max and min so far */
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max)
                    minmax.max = arr[i];
                if (arr[i + 1] < minmax.min)
                    minmax.min = arr[i + 1];
            } else {
                if (arr[i + 1] > minmax.max)
                    minmax.max = arr[i + 1];
                if (arr[i] < minmax.min)
                    minmax.min = arr[i];
            }
            i += 2; /* Increment the index by 2 as two 
               elements are processed in loop */
        }

        return minmax;
    }

    public static void main(String[] args) {
        int data[] = new int[]{1000, 11, 445, 1, 330, 3000};
        MinMax instance = new MinMax();
        Pair minMax = instance.getMinMax(data, data.length);
        System.out.println("Max:" + minMax.max + " and min:" + minMax.min);
    }
}
