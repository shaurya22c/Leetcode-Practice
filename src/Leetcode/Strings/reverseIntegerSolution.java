package Leetcode.Strings;

public class reverseIntegerSolution {
    public int reverse(int x) {
        int reversed_result= 0;

        while(x!= 0){
            int pop= x%10;
            x= x/10;

            //for edge cases
            if(reversed_result> Integer.MAX_VALUE/10 || reversed_result== Integer.MAX_VALUE && pop>7) return 0;
            if(reversed_result< Integer.MIN_VALUE/10 || reversed_result== Integer.MIN_VALUE && pop<-8) return 0;

            reversed_result= reversed_result*10+ pop;
        }
        return reversed_result;
    }

    public static void main(String[] args) {
        reverseIntegerSolution o= new reverseIntegerSolution();
        System.out.println(o.reverse(123));
    }
}
