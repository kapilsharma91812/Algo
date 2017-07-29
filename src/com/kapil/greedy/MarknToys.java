package com.kapil.greedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kapilsharma on 28/07/17.
 */
public class MarknToys {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/kapil/input1.txt");
        Scanner in = new Scanner(file);
        int items = in.nextInt();
        long totalMoney = in.nextInt();
        Integer arr[] = new Integer[items];
        for (int i = 0; i < items; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int i;
        for (i = 0; i < items; i++) {
            if (totalMoney < arr[i]) {
                break;
            }
            totalMoney = totalMoney - arr[i];

        }
        System.out.println(i);
    }
}
