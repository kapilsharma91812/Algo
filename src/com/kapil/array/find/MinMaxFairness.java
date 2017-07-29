package com.kapil.array.find;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kapilsharma on 29/07/17.
 *
 */

/*
* Given a list of  integers, your task is to select  integers from the list such that its unfairness is minimized.
if  are  numbers selected from the list , the unfairness is defined as
where max denotes the largest integer among the elements of , and min denotes the smallest integer among the elements of .
Note: Integers in the list  may not be unique.
Input Format
The first line contains an integer .
The second line contains an integer .
 lines follow. Each line contains an integer that belongs to the list .

Output Format

Output Format
An integer that denotes the minimum possible value of unfairness.

Sample Input 0

7
3
10
100
300
200
1000
20
30
Sample Output 0

20
Explanation 0

Here ; selecting the  integers , unfairness equals

max(10,20,30) - min(10,20,30) = 30 - 10 = 20
Sample Input 1

10
4
1
2
3
4
10
20
30
40
100
200
Sample Output 1

3
Explanation 1

Here ; selecting the  integers , unfairness equals

max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
*
* */

public class MinMaxFairness {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/kapil/input1.txt");
        Scanner in = new Scanner(file);
        Integer arr[] = new Integer[in.nextInt()];
        int k = in.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Integer(in.nextInt());
        }
        Arrays.sort(arr);
        int start = 0;
        int fairness = Integer.MAX_VALUE;
        int end = k - 1;
        while(end < arr.length) {
            int newFairness = arr[end] - arr[start];
            if (newFairness < fairness) {
                fairness = newFairness;
            }
            start++;
            end++;
        }
        System.out.println(fairness);

    }
}
