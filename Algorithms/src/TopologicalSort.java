// Using Tarjan
// Implemented on an adjacency list representation of graph.

// Check if there is cycle in the graph first.
// Can only work on directed acyclic graphs.

import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSort {

    int V;
    LinkedList<Integer>[] adjList;

    public TopologicalSort(int V) {
        this.V = V;
        adjList = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    public LinkedList getNeighbors(int vertex) {
        return adjList[vertex];
    }

    public ArrayList<Integer> topSort() {
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int[] inDegree = new int[V];

        // Initialize visited and inDegree arrays
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            inDegree[i] = 0;
        }

        // Update the in degree per vertex
        for (int i = 0; i < V; i++) {
            for (int n : adjList[i]) {
                inDegree[n]++;
            }
        }

        // Add vertices with 0 in degree to queue and
        // mark as visited
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.addLast(i);
                visited[i] = true;
            }
        }

        while (q.size() > 0) {
            int vertex = q.removeFirst();
            path.add(vertex);

            for (int n : adjList[vertex]) {
                if (!visited[n]) {
                    inDegree[n]--;
                    if (inDegree[n] == 0) {
                        visited[n] = true;
                        q.addLast(n);
                    }
                }
            }
        }

        return path;
    }

    public static void main(String[] args) {
        TopologicalSort t = new TopologicalSort(6);

        t.addEdge(0, 1);
        t.addEdge(1, 2);
        t.addEdge(2, 5);
        t.addEdge(0, 3);
        t.addEdge(1, 3);
        t.addEdge(2, 3);
        t.addEdge(3, 4);
        t.addEdge(2, 4);
        t.addEdge(4, 5);
        t.addEdge(3, 5);

        ArrayList<Integer> answer = t.topSort();
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
