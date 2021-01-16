package BasicsJava;
import java.util.*;
public class heapsPractice {
    public static void main(String[] args) {
        int[] items= {2,8,4,9,1,7};

        //implementing max heap:
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return b-a;
                    }
        }
        );

        //implementing min heap: by default java makes min heap
        PriorityQueue<Integer> minHeap= new PriorityQueue<Integer>(
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return a-b;
                    }
                }
        );

        for(int item: items){
            maxHeap.add(item);
            minHeap.add(item);
        }
        System.out.println("Elements in maxHeap");
        while(maxHeap.size()!= 0){
            System.out.println(maxHeap.poll());
        }
        System.out.println("Elements in minHeap");
        while(minHeap.size()!= 0){
            System.out.println(minHeap.poll());
        }

    }
}
