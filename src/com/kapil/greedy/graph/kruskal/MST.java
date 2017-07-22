package com.kapil.greedy.graph.kruskal;

import java.util.Arrays;

/**
 * Created by kapilsharma on 20/07/17.
 */
public class MST {
    int vertexCount;
    int edgesCount;
    Edge edges[];

    public MST(int vertexCount, int edgesCount) {
        this.vertexCount = vertexCount;
        this.edgesCount = edgesCount;
        edges = new Edge[edgesCount];
        for (int i = 0; i < edgesCount; i++) {
            edges[i] = new Edge();
        }
    }

    public static void main(String[] args) {
        int V = 4;  // Number of vertices in mst
        int E = 5;  // Number of edgess in mst
        MST mst = new MST(V, E);

        // add edges 0-1
        mst.edges[0].src = 0;
        mst.edges[0].dest = 1;
        mst.edges[0].weight = 10;

        // add edges 0-2
        mst.edges[1].src = 0;
        mst.edges[1].dest = 2;
        mst.edges[1].weight = 6;

        // add edges 0-3
        mst.edges[2].src = 0;
        mst.edges[2].dest = 3;
        mst.edges[2].weight = 5;

        // add edges 1-3
        mst.edges[3].src = 1;
        mst.edges[3].dest = 3;
        mst.edges[3].weight = 15;

        // add edges 2-3
        mst.edges[4].src = 2;
        mst.edges[4].dest = 3;
        mst.edges[4].weight = 4;
        Edge[] result = mst.kruskalMST();
        printMST(result);
    }

    private static void printMST(Edge[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("src:" + result[i].src + " dest:" + result[i].dest + " we:" + result[i].weight);
        }
    }


    private Edge[] kruskalMST() {
        Edge[] result = initResult();
        Subset subset[] = initSubset();
        Arrays.sort(edges);

        int resultcount = 0;
        int edgeCount = 0;

        while (resultcount < vertexCount - 1) {
            Edge edge = edges[edgeCount++];
            int xRoot = find(subset, edge.src);
            int yRoot = find(subset, edge.dest);
            if (xRoot != yRoot) {
                result[resultcount++] = edge;
                union(subset, xRoot, yRoot);
            }
        }
        return result;


    }

    private Subset[] initSubset() {
        Subset subset[] = new Subset[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            subset[i] = new Subset();
            subset[i].parent = i;
            subset[i].rank = 0;
        }
        return subset;
    }

    private Edge[] initResult() {
        Edge result[] = new Edge[vertexCount - 1];
        for (int i = 0; i < vertexCount - 1; i++) {
            result[i] = new Edge();
        }
        return result;
    }

    private void union(Subset[] subset, int xRoot, int yRoot) {
        if (subset[xRoot].rank > subset[yRoot].rank) {
            subset[yRoot].parent = xRoot;
        } else if (subset[xRoot].rank < subset[yRoot].rank) {
            subset[xRoot].parent = yRoot;
        } else {
            subset[yRoot].parent = xRoot;
            subset[xRoot].rank++;

        }

    }

    private int find(Subset[] subset, int i) {
        if (subset[i].parent != i) {
            subset[i].parent = find(subset, subset[i].parent);
        }
        return subset[i].parent;
    }
}
