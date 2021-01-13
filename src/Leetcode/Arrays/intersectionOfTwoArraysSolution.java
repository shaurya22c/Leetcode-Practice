package Leetcode.Arrays;

import java.util.Arrays;

public class intersectionOfTwoArraysSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int length1= nums1.length;
        int length2= nums2.length;
        int length3= length1*length2;
        int i=0,j=0,k=0;
        int nums3[]= new int[length3];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i<length1 && j<length2){
            if(nums1[i]< nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                nums3[k++]= nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums3, 0, k);
    }

    public static void main(String[] args) {
        intersectionOfTwoArraysSolution o= new intersectionOfTwoArraysSolution();
        int[]nums1= {1,2,2,1};
        int[]nums2= {2,2};
        System.out.println(Arrays.toString(o.intersect(nums1, nums2)));
    }
}
