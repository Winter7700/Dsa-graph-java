import java.util.ArrayList;
import java.util.List;

public class GraphAdjList extends Graph {
    private List<List<Integer>> adjacencyList;
    private int numVertices;
    private int numEdges;

    public GraphAdjList(int size) {
        this.numVertices = size;
        this.adjacencyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        this.numEdges = 0;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (!adjacencyList.get(v1).contains(v2)) {
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1); // For undirected graph
            numEdges++;
        }
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return new ArrayList<>(adjacencyList.get(v));
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
