import java.util.LinkedList;

/**
 * Created by KJH on 2016-11-14.
 */
public class Prim {

    LinkedList<Edge> list = new LinkedList<>();
    private final int INF = Integer.MAX_VALUE;
    char[] vertices;
    int[] distance;
    char[] prev;
    boolean[] visited;
    PriorityQueue priorityQueue = new PriorityQueue();

    public Prim(int[][] weight){
        int len = weight.length;
        vertices = new char[len];
        distance = new int[len];
        prev = new char[len];
        visited = new boolean[len];

        init(weight, len);

        while(!priorityQueue.isEmpty()){
            Edge start = priorityQueue.extract_min();
            list.add(start);
            visited[index(start.vertex)] = true;
            for(int i=0 ; i<len ; i++){
                if(weight[index(start.vertex)][i] != INF && index(start.vertex) != i) {
                    if(distance[i] > weight[index(start.vertex)][i] && visited[i] == false){
                        prev[i] = start.vertex;
                        distance[i] = Math.min(distance[i], weight[index(start.vertex)][i]);
                    }
                    priorityQueue.setNode(prev[i], vertices[i], distance[i]);
                }
            }
        }
        print();
    }

    private void print(){
        while(!list.isEmpty()){
            Edge print = list.remove(0);
            System.out.println("w<" + print.prev + ", " + print.vertex + "> = " + print.weight);
        }
        System.out.println();
        int sum = 0;
        for(int i=0 ; i<distance.length ; i++)
            sum += distance[i];

        System.out.println("w<MST> = " + sum);
    }

    private void init(int[][] weight, int len) {
        char start_alphabet = 97; // 'a'

        for(int i=0 ; i<len ; i++){
            vertices[i] = start_alphabet++;
            for(int j=0 ; j<len ; j++){
                if(i == j)
                    weight[i][j] = 0;
                else if(weight[i][j] == 0)
                    weight[i][j] = INF;
            }
            if(i != 0)
                distance[i] = INF;
            add(vertices[i], distance[i]);
        }
    }

    private void add(char v, int distance){
        Edge edge = new Edge(v, distance);
        priorityQueue.add(edge);
    }

    private int index(char v){
        for(int i=0 ; i<vertices.length ; i++){
            if(vertices[i] == v)
                return i;
        }
        return -1;
    }
}
