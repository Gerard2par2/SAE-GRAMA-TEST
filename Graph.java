import java.util.ArrayList;
public class Graph {

    private final ArrayList<Path> arrayGraph;

    public Graph(){
        arrayGraph = new ArrayList<>();
    }

    public ArrayList<Path> getArrayGraph() {
        return arrayGraph;
    }

    public void addPath(Path path){
        arrayGraph.add(path) ;
    }

    public void displayGraph(){
        for(Path path : arrayGraph){
            System.out.println(path);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Path path : arrayGraph){
            stringBuilder.append(path.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
