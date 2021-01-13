package Leetcode.Arrays;

import java.util.*;

public class funWithAnagrams {

    static List<String> funWithAnagrams(List<String> text){
        HashSet<String> result_set= new HashSet<>();
        List<String> result_list= new ArrayList<>();

        for(int i=0; i<text.size(); i++){
            char[] sString= text.get(i).toCharArray();
            Arrays.sort(sString);
            if(!result_set.contains(new String (sString))){
                result_list.add(text.get(i));
                result_set.add(new String (sString));
            }
        }
        Collections.sort(result_list);
        return result_list;
    }

    public static void main(String[] args) {
        List<String> str= new ArrayList<>();
        str.add("code");
        str.add("doce");
        str.add("ecod");
        str.add("framer");
        str.add("frame");
        System.out.println(funWithAnagrams(str));
    }
}
