package Leetcode.Arrays;
import java.util.*;
public class topKFrequentClass {

    public static List<String> topKFrequent(String[] words, int k){
        List<String> result= new ArrayList<>();
        HashMap<String, Integer> map= new HashMap<>();

        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
//        for(Map.Entry<String, Integer> e: map.entrySet()){
//            System.out.println("Key: "+e.getKey());
//            System.out.println("Value: "+e.getValue());
//        }
//        PriorityQueue<Map.Entry<String, Integer>> pq= new PriorityQueue<>(
//                (a,b)-> a.getValue()== b.getValue()? b.getKey().compareTo(a.getKey()): a.getValue()-b.getValue()
//        );
        PriorityQueue<String> pq= new PriorityQueue<>(
                new Comparator<String>(){
                    @Override
                    public int compare(String word1, String word2){
                        int frequency1= map.get(word1);
                        int frequency2= map.get(word2);
                        if(frequency1== frequency2) return word2.compareTo(word1);
                        return frequency1-frequency2;
                    }
                }
        );

//        for(Map.Entry<String, Integer> e:map.entrySet()){
//            pq.offer(e);
//            if(pq.size()> k){
//                pq.poll();
//            }
//        }
        for(Map.Entry<String, Integer> e:map.entrySet()){
            pq.offer(e.getKey());
            if(pq.size()> k){
                pq.poll();
            }
        }
//        while(!pq.isEmpty()){
//            result.add(pq.poll().getKey());
//        }
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String[] words= {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k= 4;
        System.out.println(topKFrequent(words, k));
    }
}
