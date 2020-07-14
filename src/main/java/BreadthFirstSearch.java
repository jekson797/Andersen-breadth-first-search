import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> {

    private Graph<T> graph;
    private ArrayList<Edge<T>> checkedEdges = new ArrayList<>();

    public BreadthFirstSearch(Graph<T> graph) {
        this.graph = graph;
    }

    public String search(T startingValue, T value) {
        if (graph.getGraph().get(startingValue).getFirst().equals(value)) {
            return "Vertex number is " + graph.getGraph().get(startingValue).getFirst().getSource();
        } else {
            Queue<Edge<T>> searchQueue = new LinkedList<>(graph.getGraph().get(startingValue));
            return searchWhileQueueIsNotEmpty(searchQueue, value);
        }
    }

    public String searchWhileQueueIsNotEmpty(Queue<Edge<T>> searchQueue, T value) {
        String answer = "Vertex isn't exist";
        while (!searchQueue.isEmpty()) {
            Edge<T> edge = searchQueue.poll();
            if(!checkedEdges.contains(edge)) {
                if (edge.getDestination().equals(value)) {
                    searchQueue.clear();
                    answer = "Vertex = " + edge.getDestination();
                } else {
                    searchQueue.addAll(graph.getGraph().get(edge.getDestination()));
                    answer = searchWhileQueueIsNotEmpty(searchQueue, value);
                }
            }
        }
        return answer;
    }
}