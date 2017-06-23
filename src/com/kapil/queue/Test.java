package com.kapil.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kapilsharma on 23/06/17.
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.poll() + ",");
        }

    }
}
