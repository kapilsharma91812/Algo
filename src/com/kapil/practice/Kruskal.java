package com.kapil.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kapilsharma on 28/11/17.
 */
public class Kruskal {
    List<Vertex> graph;

    public static class EdgeSort implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Vertex {
        int id;
        int parent;
        List<Edge> edgeList;

        Vertex(int id) {
            this.id = id;
            edgeList = new ArrayList<>();
            this.parent = id;
        }
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();

        kruskal.graph = new ArrayList<>();
        initGraph(kruskal.graph);
        List<Edge> edgesList = getEdges(kruskal.graph);
        List<Edge> resultList = new ArrayList<>();
        edgesList.sort(new EdgeSort());
        for(Edge edge: edgesList) {
            System.out.println(edge.weight + " for: " + edge.src + " -> " + edge.dest);
        }
        for(Edge edge: edgesList) {
           int uRoot = findParent(edge.src, kruskal.graph);
            int vRoot = findParent(edge.dest, kruskal.graph);

            if (uRoot != vRoot) {
                resultList.add(edge);
                union(uRoot, vRoot, kruskal.graph);
            }

        }
        System.out.println("************* After doing process *****************");

        for(Edge edge: resultList) {
            System.out.println(edge.weight + " for: " + edge.src + " -> " + edge.dest);
        }



    }

    private static void union(int uRoot, int vRoot, List<Vertex> graph) {
        graph.get(uRoot).parent = vRoot;
    }

    private static int findParent(int id, List<Vertex> graph) {
        if (graph.get(id).parent != id) {
            return findParent(graph.get(id).parent, graph);
        }
        return id;
    }


    private static List<Edge> getEdges(List<Vertex> graph) {
        List<Edge> edgeList = new ArrayList<>();
        for(Vertex vertex: graph) {
            edgeList.addAll(edgeList.size(), vertex.edgeList);
        }
        return edgeList;
    }

    private static void initGraph(List<Vertex> graph) {
        graph.add(new Vertex(0));
        graph.add(new Vertex(1));
        graph.add(new Vertex(2));
        graph.add(new Vertex(3));
        graph.add(new Vertex(4));
        graph.add(new Vertex(5));
        graph.add(new Vertex(6));
        graph.add(new Vertex(7));
        graph.add(new Vertex(8));

        addEdge(graph.get(0), 1, 4);
        addEdge(graph.get(0), 7, 8);

        addEdge(graph.get(1), 2, 8);
        addEdge(graph.get(1), 7, 11);

        addEdge(graph.get(2), 3, 7);
        addEdge(graph.get(2), 5, 4);
        addEdge(graph.get(2), 8, 2);

        addEdge(graph.get(3), 4, 9);
        addEdge(graph.get(3), 5, 14);

        addEdge(graph.get(4), 5, 10);

        addEdge(graph.get(5), 6, 2);

        addEdge(graph.get(6), 7, 1);
        addEdge(graph.get(6), 8, 6);

        addEdge(graph.get(7), 8, 7);
    }

    private static void addEdge(Vertex vertex, int dest, int weight) {
        vertex.edgeList.add(new Edge(vertex.id, dest, weight));
    }
}
