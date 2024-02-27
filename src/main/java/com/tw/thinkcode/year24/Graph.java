package com.tw.thinkcode.year24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    static class Edge {
        int source, destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    int v;
    List<List<Edge>> adj;

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Edge>());
        }
    }

    public void addEdge(int source, int destination) {
        Edge edge = new Edge(source, destination);
        adj.get(source).add(edge);
    }

    public void printGraph() {
        for (int i = 0; i < v; i++) {
            List<Edge> edges = adj.get(i);
            for (int j = 0; j < edges.size(); j++) {
                System.out.println("(" + i + ")" + "------" + "(" + edges.get(j).destination + ")");
            }
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current + " ");
            List<Edge> edges = adj.get(current);
            for (int i = 0; i < edges.size(); i++) {
                int destination = edges.get(i).destination;
                if (!visited[destination]) {
                    visited[destination] = true;
                    queue.add(destination);
                }
            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[v];
        dfsutil(start, visited);
    }

    private void dfsutil(int currNode, boolean[] visited) {
        System.out.print(currNode + " ");
        visited[currNode] = true;
        var neighbours = adj.get(currNode);
        for (Edge neighbour : neighbours) {
            if (!visited[neighbour.destination]) {
                dfsutil(neighbour.destination, visited);
            }
        }
    }

    // All path from source to target
    public void printAllPath(int src, int dest) {
        boolean[] visited = new boolean[v];
        pathUtil(src, src + " ", dest, visited);
    }

    private void pathUtil(int curr, String path, int target, boolean[] visited) {
        if (curr == target) {
            System.out.println(path);
            return;
        }
        var neighbours = adj.get(curr);
        for (Edge neighbour : neighbours) {
            if (!visited[neighbour.destination]) {
                visited[curr] = true;
                pathUtil(neighbour.destination, path + neighbour.destination + " ", target, visited);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.printGraph();
        graph.bfs(0);
        System.out.println();
        graph.dfs(0);
        System.out.println();
        graph.printAllPath(0, 3);
    }

}
