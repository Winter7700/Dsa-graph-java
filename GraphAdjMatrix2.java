import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix2 extends Graph2 {
    private int[][] adjacencyMatrix;
    private int numVertices;
    private int numEdges;

    public GraphAdjMatrix2(int size) {
        this.numVertices = size;
        this.adjacencyMatrix = new int[size][size];
        this.numEdges = 0;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (adjacencyMatrix[v1][v2] == 0) {
            adjacencyMatrix[v1][v2] = 1;
            adjacencyMatrix[v2][v1] = 1; // For undirected graph
            numEdges++;
        }
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        return getNeighbors(v); // Same for undirected graph
    }

    @Override
    public int getDegree(int v) {
        return getNeighbors(v).size();
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    // Method to compute the distance of two hops
    public List<Integer> getDistance2(int v) {
        List<Integer> distance2 = new ArrayList<>();
        List<Integer> neighbors = getNeighbors(v);
        for (int neighbor : neighbors) {
            distance2.addAll(getNeighbors(neighbor));
        }
        return distance2;
    }
}
