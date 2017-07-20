package com.kapil.backtracking.kruskal;

/**
 * Created by kapilsharma on 20/07/17.
 */
public class Edge implements Comparable<Edge> {
    int src, dest, weight;

    @Override
    public int compareTo(Edge other) {
        return weight - other.weight;
    }
}
