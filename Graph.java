import java.util.ArrayList;
public class Graph {

    private final ArrayList<Node> nodes;
    private final ArrayList<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public ArrayList<Edge> getEdges() {return edges;}
    public ArrayList<Node> getNodes() {return nodes;}

    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public void addNode(Node node){
        nodes.add(node);
    }


}
