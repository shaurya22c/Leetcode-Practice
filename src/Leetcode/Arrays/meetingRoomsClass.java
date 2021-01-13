package Leetcode.Arrays;
import java.util.*;
public class meetingRoomsClass {

    public static boolean meetingRooms(int [][]intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                }
        );
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int intervals[][]= {{7,10},{2,4}};
        System.out.println(meetingRooms(intervals));
    }
}
