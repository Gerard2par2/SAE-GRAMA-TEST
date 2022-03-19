public class Path {
    private String depNode; // noeud de départ du chemin
    private String arrNode; // noeud d'arrivée du chemin
    private String line;    // arrete du chemin
    private int depType;    // type du noeud de depart, 0 pour ville, 1 pour restaurant et 2 pour loisir
    private int arrType;
    private int lineType;   // type de l'arrete : 0 pour autoroute, 1 pour nationale et 2 pour departmentale


    public Path(String depNode, int depType, String arrNode, int arrType, String line, int lineType){
        this.depNode = depNode;
        this.depType = depType;
        this.arrNode = arrNode;
        this.arrType = arrType;
        this.line = line;
        this.lineType = lineType;
    }

    // Getters
    public String getArrNode() {return arrNode;}
    public String getDepNode() {return depNode;}
    public String getLine() {return line;}

    //Setters
    public void setArrNode(String arrNode) {this.arrNode = arrNode;}
    public void setDepNode(String depNode) {this.depNode = depNode;}
    public void setLine(String line) {this.line = line;}

    @Override
    public String toString(){
        return depNode + ", " + line+ ", " + arrNode;
    }
}
