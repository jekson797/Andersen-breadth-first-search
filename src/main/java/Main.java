public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 4, 2);
        graph.addEdge(5, 4, 3);
        graph.addEdge(4, 6, 1);
        System.out.println(graph);
        BreadthFirstSearch<Integer> search = new BreadthFirstSearch<>(graph);
        System.out.println(search.search(0, 6));
    }
}
