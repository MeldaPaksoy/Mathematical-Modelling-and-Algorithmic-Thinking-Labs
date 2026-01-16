import java.util.Arrays;

//class for weighed undirected Graph with the parameter “int nov”
public class Graph {
    private int nov; // number of vertices
    private int[][] adjMatrix; // adjacency matrix
    private final int INF = Integer.MAX_VALUE; // representation of infinity

    // Constructor
    public Graph(int nov) {
        this.nov = nov;
        adjMatrix = new int[nov][nov];

        // Initializing the matrix
        for (int i = 0; i < nov; i++) {
            for (int j = 0; j < nov; j++) {
                if (i == j)
                    adjMatrix[i][j] = 0;
                else
                    adjMatrix[i][j] = INF;
            }
        }
    }
    

    // AddEdge method
    public void addEdge(int source, int dest, int weight) {
        adjMatrix[source][dest] = weight;
        adjMatrix[dest][source] = weight; // Since the graph is undirected
    }

    // Prim's Algorithm
    public void primMST() {
        int[] parent = new int[nov];   // Stores constructed MST
        int[] key = new int[nov];      // Key values used to pick minimum weight edge
        boolean[] mstSet = new boolean[nov]; // To represent set of vertices included in MST

        // Initialize all keys as infinite
        Arrays.fill(key, INF);

        // First vertex is picked as root of MST
        key[0] = 0;     // Start from vertex 0
        parent[0] = -1; // First node is always root of MST

        // Construct MST
        for (int count = 0; count < nov - 1; count++) {
            int u = minKey(key, mstSet); // Pick the min key vertex not yet included
            mstSet[u] = true;

            for (int v = 0; v < nov; v++) {
                // Update key only if adjMatrix[u][v] is smaller than key[v]
                if (adjMatrix[u][v] != INF && !mstSet[v] && adjMatrix[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = adjMatrix[u][v];
                }
            }
        }

        // Print MST result
        System.out.println("Edge \tWeight");
        for (int i = 1; i < nov; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + adjMatrix[i][parent[i]]);
        }
    }

    // Helper method to find vertex with minimum key value
    private int minKey(int[] key, boolean[] mstSet) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < nov; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    
    // main method to test functions
        public static void main(String[] args) {
            Graph g = new Graph(5);

            g.addEdge(0, 1, 2);
            g.addEdge(0, 3, 6);
            g.addEdge(1, 2, 3);
            g.addEdge(1, 3, 8);
            g.addEdge(1, 4, 5);
            g.addEdge(2, 4, 7);
            g.addEdge(3, 4, 9);

            g.primMST();
        }
   
}


/*  6. What is the worst-case time complexity of your Prim’s algorithm?  
time complexity is O(V^2) when V is the number of vertices.

7. Explain why it has this time complexity?
Code iterates each vertices 1 time. This makes V iterations when V is number of vertices.
In each iteration, it search all vertices to find the one with the minimum key not yet included in Graph. This makes V operations for each iteration.

Therefore, the worst case time complexity = O(V) * O(V) = O(V^2)

*/
