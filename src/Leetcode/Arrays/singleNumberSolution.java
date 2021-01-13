package Leetcode.Arrays;

import java.util.HashMap;

public class singleNumberSolution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i: nums){
            if(map.get(i)== 1){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums= {4,1,2,1,2};
        singleNumberSolution o= new singleNumberSolution();
        System.out.println(o.singleNumber(nums));
    }
}
