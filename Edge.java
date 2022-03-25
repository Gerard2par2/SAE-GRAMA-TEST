import java.util.Objects;

public class Edge {
    private String name;
    private char type;
    private int length;
    private Node node1;
    private Node node2;

    public Edge(String name, char type, int length) {
        this.name = name;
        this.type = type;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return type == edge.type && length == edge.length && Objects.equals(name, edge.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, length);
    }

    @Override
    public String toString() {
        return "Edge " + this.type + this.name + ", Length : " + this.length;
    }
}
