import java.util.ArrayList;

/**
 * Created by KJH on 2016-11-14.
 */
public class PriorityQueue {

    ArrayList<Edge> arrayList = new ArrayList<>();

    public void add(Edge e){
        arrayList.add(e);
        build_min_heap();
    }

    private void min_heapify(int index){
        int leftChildIndex = index*2+1;
        int rightChildIndex = index*2+2;
        int smallest = index;

        if(leftChildIndex <= arrayList.size()-1 && arrayList.get(leftChildIndex).weight < arrayList.get(index).weight)
            smallest = leftChildIndex;

        if(rightChildIndex <= arrayList.size()-1 && arrayList.get(rightChildIndex).weight < arrayList.get(index).weight)
            smallest = rightChildIndex;

        if(smallest != index) {
            swapNode(index, smallest);
            min_heapify(smallest);
        }
    }

    public void setNode(char p, char v, int distance){
        for(int i=0 ; i<arrayList.size() ; i++){
            if(arrayList.get(i).vertex == v){
                arrayList.set(i, new Edge(p, v, distance));
            }
        }
        build_min_heap();
    }

    public void build_min_heap(){
        for(int i = (arrayList.size()-1)/2; i>=0 ; i--)
            min_heapify(i);
    }

    private void swapNode(int index, int smallest) {
        Edge temp = arrayList.get(index);
        arrayList.set(index, arrayList.get(smallest));
        arrayList.set(smallest, temp);
    }

    public Edge extract_min(){
        Edge ret = arrayList.remove(0);
        build_min_heap();
        return ret;
    }

    public boolean isEmpty(){
        return arrayList.size() == 0;
    }
}