import java.util.Iterator;
import java.util.LinkedList;

/*
Graph implemented with adjacency list.
Unweighted and undirected.
 */
public class GraphAdjList {

    private LinkedList<Integer>[] adjList;
    private int V;

    public GraphAdjList(int V) {
        this.V = V;
        this.adjList = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v1, int v2) {
        if (!isValidEdge(v1, v2)) {
            System.out.println("Edge is not valid.");
            return;
        }

        if (!adjList[v1].contains(v2)) {
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
    }

    public boolean containsEdge(int v1, int v2) {
        if (isValidEdge(v1, v2)) {
            return adjList[v1].contains(v2);
        } else {
            System.out.println("Edge is not valid.");
            return false;
        }
    }

    public boolean isValidEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= V || v2 < 0 || v2 >= V) {
            return false;
        } else {
            return true;
        }
    }

    public void printAdjList() {
        for (int i = 0; i < V; i++) {
            Iterator iterator = adjList[i].iterator();

            System.out.print("Adj list for " + i + ": ");

            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }

            System.out.println("");
        }
    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(5);

        System.out.println(graph.containsEdge(1, 4));

        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(0, 2);
        graph.addEdge(4, 5);

        graph.printAdjList();

        System.out.println(graph.containsEdge(2, 4));
        System.out.println(graph.containsEdge(1, 3));

        System.out.println(graph.containsEdge(4, 5));
    }
}
