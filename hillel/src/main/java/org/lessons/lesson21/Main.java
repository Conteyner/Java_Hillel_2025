package org.lessons.lesson21;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        System.out.println("Graph:");
        graph.printGraph();
        System.out.println("\nIs there a vertex 2: " + graph.hasVertex(2));
        System.out.println("Is there a vertex 5: " + graph.hasVertex(5));
        System.out.println("Is there an edge (1 ; 3): " + graph.hasEdge(1, 3));
        System.out.println("Is there an edge (2 ; 4): " + graph.hasEdge(2, 4));
        graph.removeEdge(1, 3);
        System.out.println("\nGraph after edge removal:");
        graph.printGraph();
        graph.removeVertex(2);
        System.out.println("\nGraph after edge removal:");
        graph.printGraph();
    }
}
