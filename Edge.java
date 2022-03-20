public class Edge {
    private final String type;
    private final Node node1;
    private final Node node2;
    private final int length;

    public Edge(Node node1, Node node2, String type, int length){
        this.type = type;
        this.node1 = node1;
        this.node2 = node2;
        this.length = length;
    }

    // Getters
    public Node getNode1() {return node1;}
    public Node getNode2() {return node2;}
    public String getType() {return type;}
    public int getLength() {return length;}
}
