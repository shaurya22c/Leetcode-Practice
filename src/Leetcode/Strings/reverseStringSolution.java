package Leetcode.Strings;

public class reverseStringSolution {
    public void reverseString(char[] s) {
        int left= 0;
        int right= s.length-1;
        while(left<right){
            char ch= s[left];
            s[left]= s[right];
            s[right]= ch;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        reverseStringSolution o= new reverseStringSolution();
        char[]ch= {'h','e','l','l','o'};
        o.reverseString(ch);
        System.out.println(ch);
    }
}
