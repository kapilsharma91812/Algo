package com.kapil.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kapilsharma on 24/06/17.
 */
public class Median {
    public static void main(String[] args) {
        int data[] = new int[]{5, 15, 1, 3};
        getMedians(data);

    }

    public static double[] getMedians(int array[]) {
        PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b)); //MinHeap
        PriorityQueue<Integer> higher = new PriorityQueue<>(); //MaxHeap
        double medians[] = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            addNumber(array[i], lower, higher);
            reBalance(lower, higher);
            medians[i] = getMedian(lower, higher);
            System.out.println("After reading: " + array[i] + " median is:" + medians[i]);
        }
        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = (lower.size() > higher.size()) ? lower : higher;
        PriorityQueue<Integer> smallerHeap = (lower.size() > higher.size()) ? higher : lower;
        if (biggerHeap.size() == smallerHeap.size()) {
            return (biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    private static void reBalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = (lower.size() > higher.size()) ? lower : higher;
        PriorityQueue<Integer> smallerHeap = (lower.size() > higher.size()) ? higher : lower;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }
    }


}
