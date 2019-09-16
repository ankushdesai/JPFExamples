

/**
 * Credit: https://github.com/isstac/canopy/blob/master/src/examples/sampling/batch/Dijkstra.java
 * @author jburnim@cs.berkeley.edu
 */
public class Dijkstra {

    static final int INFINITY = Integer.MAX_VALUE;

    static int[] runDijkstra(int N, int D[][], int src) {
        // Initialize distances.
        int dist[] = new int[N];
        boolean fixed[] = new boolean[N];
        for (int i = 0; i < N; i++) {  // V+1 branches
            dist[i] = INFINITY;
            fixed[i] = false;
        }
        dist[src] = 0;

        for (int k = 0; k < N; k++) { // V+1 branches
            // Find the minimum-distance, unfixed vertex.
            int min = -1;
            int minDist = INFINITY;
            for (int i = 0; i < N; i++) { // V(V+1) branches
                if (!fixed[i] && (dist[i] < minDist)) { // V^2 + V(V+1)/2
                    min = i;
                    minDist = dist[i];
                }
            }

            // Fix the vertex.
            fixed[min] = true;

            // Process the vertex's outgoing edges.
            for (int i = 0; i < N; i++) { // V(V+1) branches
                // V^2 + V(V-1)/2 branches
                if (!fixed[i] && (dist[min] + D[min][i] < dist[i])) {
                    dist[i] = dist[min] + D[min][i];
                }
            }
            
        }

        // Return the computed distances.
        return dist;
    }

    public static void main(String[] args) {
        final int V = 1000;

        final int D[][] = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i ==j) continue;
                D[i][j] = i+j;//Concolic.input.Integer(0, 1000);
            }
        }

        // We only measure the complexity (i.e. path length) of the
        // graph algorithm itself.  That is, we count branches only
        // from this point forward in the execution.
       // Concolic.ResetBranchCounting();

        runDijkstra(V, D, 0);
    }
}