import javax.crypto.AEADBadTagException;
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

    public Node closestNeighbour(Node node){
        // returns the closest neighbour of the specified node
        int shortestLength = 2000;
        Node closestNode = null;
        for(Edge edge : edges){
            if(edge.getNode1().equals(node) && edge.getLength()<shortestLength){
                closestNode = edge.getNode2();
                shortestLength = edge.getLength();
            }
        }
        return closestNode;
    }

    public ArrayList<Node> directNeighbours(Node node){
        // returns all neighbours 1 jump away from the node
        ArrayList<Node> neighbours = new ArrayList<>();
        for(Edge edge : edges){
            if(edge.getNode1().equals(node)){
                neighbours.add(edge.getNode2());
            }
        }
        return neighbours;
    }

    public ArrayList<Node> neighbourCities(Node node){
        //returns all the cities 1 jump away from the node
        ArrayList<Node> cities = new ArrayList<>();
        for(Edge edge : edges){
            if(edge.getNode1().equals(node)){
                cities.add(edge.getNode2());
            }
        }
        return cities;
    }

    public boolean twoJumpsAwayTypeNodes(Node node1, Node node2){
        //returns true if the nodes are 2 jumps away
        for(Edge edge1 : edges){
            //goes through all the edges
            if(edge1.getNode1().equals(node1)){
                //an edge coming from node1 is found
                for(Edge edge2 : edges){
                    //goes through all the edges again
                    if(edge2.getNode1().equals(edge1.getNode2()) && edge2.getNode2().equals(node2)){
                        //a 2 length path from node1 to node2 has been found
                        return true;
                    }
                }
            }
        }
        //there is no 2 length path from node1 to node2
        return false;
    }

    public ArrayList<Node> getCities(){
        // returns an array list of all the cities
        ArrayList<Node> cities = new ArrayList<>();
        for(Node node : nodes){
            if(node.getType() == 'V'){
                cities.add(node);
            }
        }
        return cities;
    }

    public ArrayList<Node> getRestaurants(){
        // returns an array list of all the restaurants
        ArrayList<Node> restaurants = new ArrayList<>();
        for(Node node : nodes){
            if(node.getType() == 'R'){
                restaurants.add(node);
            }
        }
        return restaurants;
    }

    public ArrayList<Node> getLeisurePlaces(){
        //returns an array list of all the leisure places
        ArrayList<Node> leisurePlaces = new ArrayList<>();
        for(Node node : nodes){
            if(node.getType() == 'L'){
                leisurePlaces.add(node);
            }
        }
        return leisurePlaces;
    }

    public ArrayList<Edge> getHighways(){
        // returns an array list of all the highways
        ArrayList<Edge> highways = new ArrayList<>();
        for(Edge edge : edges){
            if(edge.getType() == 'A'){
                highways.add(edge);
            }
        }
        return highways;
    }

    public ArrayList<Edge> getNationals(){
        // returns an array list of all the nationals
        ArrayList<Edge> nationals = new ArrayList<>();
        for(Edge edge : edges){
            if(edge.getType() == 'N'){
                nationals.add(edge);
            }
        }
        return nationals;
    }

    public ArrayList<Edge> getDepartmentals(){
        // returns an array list of all the departmentals
        ArrayList<Edge> departmentals = new ArrayList<>();
        for(Edge edge : edges){
            if(edge.getType() == 'D'){
                departmentals.add(edge);
            }
        }
        return departmentals;
    }


    public int twoJumpsAwayTypeNodes(Node node1, char type){
        int c = 0;
        //returns the number of 2 length paths from node1 and a node of the specified type
        for(Edge edge1 : edges){
            //goes through all the edges
            if(edge1.getNode1().equals(node1)){
                //an edge coming from node1 is found
                for(Edge edge2 : edges){
                    //goes through all the edges again
                    if(edge2.getNode1().equals(edge1.getNode2()) && edge2.getNode2().getType() == type){
                        //a 2 length path from node1 to a node of the specified type has been found
                        c++;
                    }
                }
            }
        }
        return c;
    }

    public boolean isMoreOpen(Node node1, Node node2){
        // returns true if there are more cities 2 jumps away from node1 than from node2
        return twoJumpsAwayTypeNodes(node1,'V') > twoJumpsAwayTypeNodes(node2,'V');
    }

    public boolean isMoreGastronomical(Node node1, Node node2){
        // returns true if there are more restaurants 2 jumps away from node1 than from node2
        return twoJumpsAwayTypeNodes(node1, 'R') > twoJumpsAwayTypeNodes(node2,'R');
    }

    public boolean isMoreCultural(Node node1, Node node2){
        // returns true if there are more cultural locations 2 jumps away from node1 than from node2
        return twoJumpsAwayTypeNodes(node1, 'L') > twoJumpsAwayTypeNodes(node2,'L');
    }
}
