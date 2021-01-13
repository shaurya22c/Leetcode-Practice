package Leetcode.Arrays;
import java.util.*;

public class mostFrequentElement {
    public static int frequent(int[]arr){
        int result= Integer.MIN_VALUE;
        int count=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //iterating through all keys in hashmap and find key with max value
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()> count){
                result= e.getKey();
                count= e.getValue();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr= {1,2,2,3,3,3,2,2,2};
        System.out.println(frequent(arr));
    }
}
