/**
 * Created by KJH on 2016-11-15.
 */
public class Edge{
    char prev;
    char vertex;
    int weight;

    public Edge(char v, int w){
        this.prev = ' ';
        this.vertex = v;
        this.weight = w;
    }

    public Edge(char p, char v, int w){
        this.prev = p;
        this.vertex = v;
        this.weight = w;
    }
}
