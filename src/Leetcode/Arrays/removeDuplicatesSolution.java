package Leetcode.Arrays;

import java.util.Arrays;

public class removeDuplicatesSolution {
    public int removeDuplicates(int[] nums) {
        int j=1;
        for(int i=0; i<nums.length-1;i++)
        {

            if(nums[i]!= nums[i+1])
            {
                nums[j]= nums[i+1];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        removeDuplicatesSolution o= new removeDuplicatesSolution();
        int[] nums=  {0,0,1,1,1,2,2,3,3,4};
        System.out.println(o.removeDuplicates(nums)); //length of final array is 5: [0,1,2,3,4]
    }
}
