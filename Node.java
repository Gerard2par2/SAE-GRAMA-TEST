public class Node {
    private final String type;
    private final String name;

    public Node(String type, String name){
        this.type = type;
        this.name = name;
    }

    // Getters
    public String getName() {return name;}
    public String getType() {return type;}
}
