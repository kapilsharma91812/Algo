package com.kapil.random;

import static java.lang.Math.abs;

/**
 * Created by kapilsharma on 21/06/17.
 */


/*
Minimum steps to reach a destination
Given a number line from -infinity to +infinity. You start at 0 and can go either to the left or to the right. The condition is that in i’th move, you take i steps.
a) Find if you can reach a given number x
b) Find the most optimal way to reach a given number x, if we can indeed reach it. For example, 3 can be reached om 2 steps, (0, 1) (1, 3) and 4 can be reached in 3 steps (0, -1), (-1, 1) (1, 4).
*
* */
public class MinStepToDestination {
    public static void main(String[] args) {
        System.out.println(steps(4));
    }

    private static int steps(int dest) {
        return stepUtil(0, 0, dest);
    }

    private static int stepUtil(int source, int step, int dest)
    {
        // base cases
        if (abs(source) > (dest))  return Integer.MAX_VALUE;
        if (source == dest)     return step;

        // at each point we can go either way

        // if we go on positive side
        int pos = stepUtil(source+step+1, step+1, dest);

        // if we go on negative side
        int neg = stepUtil(source-step-1, step+1, dest);

        // minimum of both cases
        return Math.min(pos, neg);
    }
}
