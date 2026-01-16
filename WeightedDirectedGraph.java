import java.util.Arrays;

//class for weighed directed Graph
public class WeightedDirectedGraph {
    private int nov; // Number of vertices
    private int[][] graph;
    private final int INF = 99999; // Representing Infinity

    // Constructor 
    public WeightedDirectedGraph(int nov) {
        this.nov = nov;
        // matrix of size nov x nov
        graph = new int[nov][nov];

        // Initializing the matrix
        for (int i = 0; i < nov; i++) {
            for (int j = 0; j < nov; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }
    }

    // addEdge method to insert an edge with the parameters “void addEdge(int source, int dest, int w)”
    public void addEdge(int source, int dest, int weight) {
   //creating an edge between vertex source to vertex dest with the weight w
        graph[source][dest] = weight;
    }

    // method to implement Floyd Warshall algorithm to find the shortest paths between any pair in the graph
    public void floydWarshall() {
        int[][] dist = new int[nov][nov];

        // Copy graph to dist matrix
        for (int i = 0; i < nov; i++) {
            for (int j = 0; j < nov; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall logic
        for (int k = 0; k < nov; k++) {
            for (int i = 0; i < nov; i++) {
                for (int j = 0; j < nov; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // printing the matrix for the shortest paths between any pair
        System.out.println("Shortest distances between every pair of vertices:");
        System.out.println("   0   1   2    3   4   5");
        System.out.println("--------------------------");
        
        for (int i = 0; i < nov; i++) {
        	System.out.print(i+"| " );
        	
            for (int j = 0; j < nov; j++) {
            	
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    // main method to test functions 
    public static void main(String[] args) {
        WeightedDirectedGraph g = new WeightedDirectedGraph(6);

        // Adding edges from the provided graph
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 4);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 5, 11);
        g.addEdge(1, 4, 8);
        g.addEdge(2, 1, 7);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 5, 9);
        g.addEdge(4, 0, 4);
        g.addEdge(4, 2, 5);
        g.addEdge(4, 5, 3);
        g.addEdge(5, 2, 2);

        g.floydWarshall();
    }
}

/*
6. What is the worst-case time complexity of Floyd-Warshall algorithm?

 O(n³), where n is the number of vertices.

7. Explain why it has this time complexity? 

The Floyd-Warshall algorithm uses three nested loops, each running from 0 to V-1. 
It checks and updates the shortest paths between all pairs of vertices,it makes 2 operation in every step. If we say n=V, total number of operations is 2n x 2n x 2n=8n^3.
When we simplify it, in worst case scenario, time complexity is O(n³).
*/






