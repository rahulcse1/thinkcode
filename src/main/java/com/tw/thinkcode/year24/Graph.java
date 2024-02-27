package com.tw.thinkcode.year24;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int v;
    List<List<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for(int i = 0; i< v; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination){
        adj.get(source).add(destination);
    }

    public void dfs(int root) {
        boolean[] visited = new boolean[v];
        dfsutil(root, visited);
    }

    private void dfsutil(int currNode, boolean[] visited){
        visited[currNode] = true;
        var neighbours = adj.get(currNode);
        for (int neighbour: neighbours) {
            if(!visited[neighbour]){
                dfsutil(neighbour, visited);
            }
        }
    }

}
