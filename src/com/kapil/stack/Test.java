package com.kapil.stack;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by kapilsharma on 23/06/17.
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + ",");
        }

    }
}
