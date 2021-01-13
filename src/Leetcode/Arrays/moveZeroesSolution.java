package Leetcode.Arrays;

import java.util.Arrays;

public class moveZeroesSolution {
    public void moveZeroes(int[] nums) {
        int index= 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!= 0){
                nums[index]= nums[i];
                index++;
            }
        }
        for(int i= index; i<nums.length; i++){
            nums[i]= 0;
        }
    }

    public static void main(String[] args) {
        int[] nums= {0,1,0,3,12};
        moveZeroesSolution o= new moveZeroesSolution();
        o.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
