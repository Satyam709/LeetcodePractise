import java.util.*;

class Graph {
    private final Map<Integer, List<Edge>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    // Adds an edge to the graph
    public void addEdge(int from, int to, double weight) {
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
    }

    // Gets the list of edges for a node
    public List<Edge> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    static class Edge {
        int to;
        double weight;

        public Edge(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

class AStar {
    private static class Node {
        int id;
        double gCost;
        double hCost;
        double fCost;
        Node parent;

        Node(int id, double gCost, double hCost) {
            this.id = id;
            this.gCost = gCost;
            this.hCost = hCost;
            this.fCost = gCost + hCost;
        }
    }

    private Graph graph;
    private Map<Integer, Node> allNodes;

    public AStar(Graph graph) {
        this.graph = graph;
        this.allNodes = new HashMap<>();
    }

    // Heuristic function: This is problem-specific, replace as needed
    private double heuristic(int current, int goal) {
        // For this example, we use a simple heuristic that returns 0 (assuming no better heuristic is available)
        // In real-world cases, this would be a better estimation (e.g., Euclidean or Manhattan distance).
        return 0;
    }

    public List<Integer> findShortestPath(int start, int goal) {
        // Priority queue to store the nodes to be explored
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingDouble(n -> n.fCost));

        // Closed list to store already explored nodes
        Set<Integer> closedList = new HashSet<>();

        // Initialize the start node
        Node startNode = new Node(start, 0, heuristic(start, goal));
        openList.add(startNode);
        allNodes.put(start, startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            closedList.add(currentNode.id);

            // If the goal node is found, reconstruct the path
            if (currentNode.id == goal) {
                return reconstructPath(currentNode);
            }

            // Explore neighbors
            for (Graph.Edge edge : graph.getNeighbors(currentNode.id)) {
                if (closedList.contains(edge.to)) {
                    continue;
                }

                double tentativeGCost = currentNode.gCost + edge.weight;
                Node neighborNode = allNodes.computeIfAbsent(edge.to, id -> new Node(id, Double.MAX_VALUE, heuristic(id, goal)));

                if (tentativeGCost < neighborNode.gCost) {
                    neighborNode.gCost = tentativeGCost;
                    neighborNode.fCost = neighborNode.gCost + neighborNode.hCost;
                    neighborNode.parent = currentNode;
                    openList.add(neighborNode);
                }
            }
        }

        // Return empty path if no path is found
        return new ArrayList<>();
    }

    // Reconstruct the path from the goal node to the start node
    private List<Integer> reconstructPath(Node goalNode) {
        List<Integer> path = new ArrayList<>();
        Node current = goalNode;
        while (current != null) {
            path.add(current.id);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph();
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(2, 4, 5);

        // Initialize A* algorithm
        AStar aStar = new AStar(graph);

        // Find shortest path from node 1 to node 4
        List<Integer> path = aStar.findShortestPath(1, 4);
        System.out.println("Shortest path: " + path);
    }

}
