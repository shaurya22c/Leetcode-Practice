package Leetcode.Arrays;

import java.util.Arrays;

public class reverseSolution {
    public void rotate(int[] nums, int k) {
        k= k%nums.length;
        reverse(nums, 0, nums.length-1); //reverse entire array first
        reverse(nums, 0, k-1); //reverse first k elements of array
        reverse(nums, k, nums.length-1); //reverse remaining elements

    }
    public void reverse(int[]nums, int start, int end){
        while(start< end){

            int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        reverseSolution o= new reverseSolution();
        int[]nums = {1,2,3,4,5,6,7};
        int k = 3;
        o.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }
}
