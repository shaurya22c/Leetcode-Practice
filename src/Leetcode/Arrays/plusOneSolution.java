package Leetcode.Arrays;

import java.util.Arrays;

public class plusOneSolution {

    public int[] plusOne(int[] digits){
        for(int i= digits.length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }

            if(digits[i]== 9){
                digits[i]= 0;
            }

        }
        int result[]= new int[digits.length+1];
        result[0]= 1;

        return result;
    }

    public static void main(String[] args) {
        int[] digits= {1,2,3};
        plusOneSolution o= new plusOneSolution();
        o.plusOne(digits);
        System.out.println(Arrays.toString(digits));
    }

}
