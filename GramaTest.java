import modules.Edge;
import modules.Graph;
import modules.Node;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GramaTest {
    public static void main(String[] args){
        /*
        Graph graph = new Graph();
        Node lux = new Node("Lux",'V');
        Node dijon = new Node("Dijon",'V');
        Node lyon = new Node("Lyon",'V');
        Node paris = new Node("Paris",'V');

        Edge edge1 = new Edge("69",'A',69,lux,dijon);

        Edge edge2 = new Edge("420",'D',78,paris,lyon);

        Edge edge3 = new  Edge("69420",'N',54,dijon,lyon);

        Node testNode = new Node("uwu",'v');
        Edge testEdge1 = new Edge("test",'A',69,testNode,lux);
        Edge testEdge2 = new Edge("test",'A',69,testNode,dijon);
        Edge testEdge3 = new Edge("test",'A',69,testNode,lyon);
        Edge testEdge4 = new Edge("test",'A',69,testNode,paris);

        graph.addNode(lux);
        graph.addNode(dijon);
        graph.addNode(lyon);
        graph.addNode(paris);

        graph.addNode(testNode);
        graph.addEdge(testEdge1);
        graph.addEdge(testEdge2);
        graph.addEdge(testEdge3);
        graph.addEdge(testEdge4);

        graph.addEdge(edge1);

        graph.addEdge(edge2);

        graph.addEdge(edge3);

        System.out.println(graph.isMoreOpen(lux,testNode));
        */
        Graph graph = readGraph();
        graph.printGraph();;
    }

    public static Graph readGraph(){
        Graph graph = new Graph();
           File file = new File("ressources//test.txt");

        try (FileReader fr = new FileReader(file))
        {
            int content;
            while ((content = fr.read()) != -1) {
               char nodeType = (char) content;

               StringBuilder stringBuilder = new StringBuilder();
               while((content = fr.read()) != ':'){
                   if(content != ','){
                       stringBuilder.append((char)content);
                   }
               }
               String nodeName = stringBuilder.toString();

               content=fr.read();
               char edgeType = (char) content;

               stringBuilder = new StringBuilder();
               while((content = fr.read()) != ':'){
                   if(content != ','){
                       stringBuilder.append((char)content);
                   }
               }
               String edgeName = stringBuilder.toString();

               content = fr.read();
               char node2Type = (char) fr.read();

                stringBuilder = new StringBuilder();
                while((content = fr.read()) != ';'){
                    if(content != ','){
                        stringBuilder.append((char)content);
                    }
                }
                String node2Name = stringBuilder.toString();

                Node node1 = new Node(nodeName,nodeType);
                Node node2 = new Node(node2Name,node2Type);
                Edge edge = new Edge(edgeName,edgeType,0,node1,node2);
                graph.addNode(node1);
                graph.addNode(node2);
                graph.addEdge(edge);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }
}
