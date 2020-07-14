import java.util.*;

public class Graph<T> {

    private Map<T, LinkedList<Edge<T>> > graph = new HashMap<>();

    public void addVertex(T value) {
        graph.put(value, new LinkedList<>());
    }

    public void addEdge(T source, T destination, int weight) {
        Edge<T> edge = new Edge<>(source, destination, weight);
        if (!graph.containsKey(source)) {
            addVertex(source);
        }
        if (!graph.containsKey(destination)) {
            addVertex(destination);
        }
        graph.get(source).add(edge);
    }

    public Map<T, LinkedList<Edge<T>>> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedList<Edge<T> > edges : graph.values()) {
            for (Edge<T> edge : edges) {
                stringBuilder.append(edge.getSource()).append(" => ").append(edge.getDestination())
                        .append(" with weight ").append(edge.getWeight()).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
