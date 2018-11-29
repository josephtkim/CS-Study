import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Graph implemented with objects.
Directed and weighted.
 */
public class Graph {

    public class Vertex {
        public String value;
        public List<Edge> neighbors;

        public Vertex(String value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Vertex neighbor, int weight) {
            this.neighbors.add(new Edge(this, neighbor, weight));
        }

        public List getNeighbors() {
            return this.neighbors;
        }
    }

    public class Edge {
        public Vertex start;
        public Vertex end;
        public int weight;

        public Edge(Vertex start, Vertex end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getWeight() {
            return this.weight;
        }
    }

    public int V;
    public int E;
    public HashMap<String, Vertex> vertices;

    public Graph() {
        this.V = 0;
        this.E = 0;
        this.vertices = new HashMap<String, Vertex>();
    }

    public void addEdge(String key1, String key2, int weight) {
        // Check if vertices are in the graph
        // If not, add them.
        Vertex v1 = vertices.get(key1);
        Vertex v2 = vertices.get(key2);

        if (v1 == null) {
            vertices.put(key1, new Vertex(key1));
        }
        if (v2 == null) {
            vertices.put(key2, new Vertex(key2));
        }

        vertices.get(key1).addNeighbor(vertices.get(key2), weight);
    }

    public void addVertex(String key) {
        Vertex v = vertices.get(key);
        if (v == null) {
            vertices.put(key, new Vertex(key));
            return;
        } else {
            return;
        }
    }

    public boolean containsVertex(String key) {
        Vertex v = vertices.get(key);
        return v != null;
    }

    public int numVertices() {
        return this.V;
    }

    public int numEdges() {
        return this.E;
    }

    public void printGraph() {
        for (String key : vertices.keySet()) {
            System.out.print("Neighbors of " + key + ": ");

            for (Edge e : vertices.get(key).neighbors) {
                System.out.print(e.end.value + " ");
            }

            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 5);
        graph.addEdge("A", "D", 10);
        graph.addEdge("A", "E", 7);

        System.out.println(graph.containsVertex("A"));
        System.out.println(graph.containsVertex("B"));

        graph.addEdge("F", "G", 7);
        graph.addEdge("E", "A", 7);
        graph.addEdge("E", "F", 7);

        graph.printGraph();
    }
}
