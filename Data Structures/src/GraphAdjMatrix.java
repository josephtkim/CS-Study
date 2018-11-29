import java.util.LinkedList;

/*
Graph implemented with adjacency matrix.
Weighted edges. Unweighted edges is simply removing the edge parameter, and
setting cell to 1.
 */
public class GraphAdjMatrix {

    private int V;
    private int[][] adjMatrix;

    public GraphAdjMatrix(int V) {
        this.V = V;
        adjMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = -1;
            }
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        if (weight < 0) {
            System.out.println("Cannot have negative edge weights");
            return;
        }

        if (isValidEdge(v1, v2)) {
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        } else {
            System.out.println("Not a valid edge");
            return;
        }
    }

    public void setEdge(int v1, int v2, int newWeight) {
        if (newWeight < 0) {
            System.out.println("Cannot have negative edge weights");
            return;
        }

        if (isValidEdge(v1, v2)) {
            adjMatrix[v1][v2] = newWeight;
            adjMatrix[v2][v1] = newWeight;
        } else {
            System.out.println("Not a valid edge.");
            return;
        }
    }

    public boolean containsEdge(int v1, int v2) {
        if (isValidEdge(v1, v2)) {
            return adjMatrix[v1][v2] > -1;
        } else {
            return false;
        }
    }

    public boolean isValidEdge(int v1, int v2) {
        if (v1 >= V || v1 < 0 || v2 >= V || v2 < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void BFS(int source) {
        boolean[] visited = new boolean[V];

        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int vertex = q.removeFirst();
            System.out.print(vertex +  " ");

            for (int i = 0; i < V; i++) {
                // Checks that it's a neighbor
                if (adjMatrix[vertex][i] != -1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.addLast(i);
                    }
                }
            }
        }
    }

    public void DFS(int source) {
        boolean[] visited = new boolean[V];

        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.removeFirst();
            System.out.print(vertex + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[vertex][i] != -1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        stack.addFirst(i);
                    }
                }
            }
        }
    }

    public void recDFS(int source) {
        boolean[] visited = new boolean[V];

        recDFSUtil(source, visited);
    }

    public void recDFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i] != -1) {
                if (!visited[i]) {
                    recDFSUtil(i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjMatrix graph = new GraphAdjMatrix(6);
        graph.printGraph();

        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(0, 2, 15);
        graph.addEdge(2, 4, 20);
        graph.addEdge(1, 2, 7);
        graph.addEdge(3, 4, 13);
        graph.addEdge(3, 5, 14);

        System.out.println(graph.containsEdge(1, 2));
        System.out.println(graph.containsEdge(1, 3));

        System.out.println(graph.isValidEdge(1, 2));
        graph.printGraph();

        System.out.println("Breadth First Search.");
        graph.BFS(0);
        System.out.println("");
        graph.BFS(2);
        System.out.println("");

        System.out.println("Depth First Search.");
        graph.DFS(0);
        System.out.println("");
        graph.DFS(4);

        System.out.println("");
        graph.recDFS(4);
        System.out.println("");
        graph.recDFS(0);
        System.out.println("");
    }
}
