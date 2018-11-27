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

    public static void main(String[] args) {
        GraphAdjMatrix graph = new GraphAdjMatrix(5);
        graph.printGraph();

        graph.addEdge(1, 2, 5);
        graph.addEdge(0, 3, 10);
        graph.addEdge(4, 4, 15);

        System.out.println(graph.containsEdge(1, 2));
        System.out.println(graph.containsEdge(1, 3));

        System.out.println(graph.isValidEdge(1, 2));
        graph.printGraph();
    }
}
