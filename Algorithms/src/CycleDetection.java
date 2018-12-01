import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
Cycle detection for a directed graph.
Augment DFS.
 */
public class CycleDetection {

    // Adjacency list graph
    int V;
    LinkedList<Integer>[] adjList;

    public CycleDetection(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjList[vertex];
    }


    public boolean hasCycle() {
        Set<Integer> whiteSet = new HashSet<>();
        Set<Integer> graySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();

        // Put all vertices to white set
        for (int i = 0; i < V; i++) {
            whiteSet.add(i);
        }

        // Go through vertices randomly and apply DFS
        while (whiteSet.size() > 0) {
            int vertex = whiteSet.iterator().next();
            if(DFS(vertex, whiteSet, graySet, blackSet)) {
                return true;
            };
        }

        return false;
    }

    public boolean DFS(int vertex, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet) {
        moveVertex(vertex, whiteSet, graySet);

        for (int n : adjList[vertex]) {
            System.out.println(n + " ");
            // If in black set, no need to explore the neighbor.
            if (blackSet.contains(n)) {
                continue;
            }

            // If neighbor is in gray set, then there is a cycle.
            if (graySet.contains(n)) {
                return true;
            }
            if (DFS(n, whiteSet, graySet, blackSet)) {
                return true;
            }
        }

        moveVertex(vertex, graySet, blackSet);
        return false;
    }

    public void moveVertex(int vertex, Set<Integer> sourceSet, Set<Integer> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

    public static void main(String[] args) {
        CycleDetection obj = new CycleDetection(6);

        obj.addEdge(0, 1);
        obj.addEdge(3, 0);
        obj.addEdge(3, 4);
        obj.addEdge(4, 5);
        obj.addEdge(5, 3);

        System.out.println(obj.hasCycle());
    }
}
