package org.lessons.lesson21;

import java.util.*;

public class Graph {
    private final Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            for (Integer n : adjacencyList.get(vertex)) {
                adjacencyList.get(n).remove(vertex);
            }
            adjacencyList.remove(vertex);
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new HashSet<>());
        adjacencyList.putIfAbsent(destination, new HashSet<>());
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
    public void removeEdge(int vertex1, int vertex2 ) {
        if (adjacencyList.containsKey(vertex1)) {
            adjacencyList.get(vertex1).remove(vertex2);
        }
        if (adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyList.get(source).contains(destination);
    }

    public void printGraph() {
        for(Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " coupled with " + entry.getValue());
        }
    }

}
