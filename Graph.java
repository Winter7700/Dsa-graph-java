import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Graph {
    // Abstract methods to be implemented by subclasses
    public abstract void addEdge(int v1, int v2);
    public abstract List<Integer> getNeighbors(int v);
    public abstract List<Integer> getInNeighbors(int v);
    public abstract int getDegree(int v);
    public abstract int getNumVertices();
    public abstract int getNumEdges();
    
    // Method to compute the degree sequence
    public List<Integer> degreeSequence() {
        List<Integer> degrees = new ArrayList<>();
        for (int v = 0; v < getNumVertices(); v++) {
            degrees.add(getDegree(v));
        }
        Collections.sort(degrees, Collections.reverseOrder());
        return degrees;
    }
}
