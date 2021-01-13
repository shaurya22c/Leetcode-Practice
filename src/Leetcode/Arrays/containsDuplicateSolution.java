package Leetcode.Arrays;

import java.util.HashSet;

public class containsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {

        boolean flag= false;
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(hs.contains(nums[i])){
                flag= true;
            }
            else{
                hs.add(nums[i]);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        containsDuplicateSolution o= new containsDuplicateSolution();
        int[] nums= {1,1,1,3,3,4,3,2,4,2};
        System.out.println(o.containsDuplicate(nums));
    }
}
