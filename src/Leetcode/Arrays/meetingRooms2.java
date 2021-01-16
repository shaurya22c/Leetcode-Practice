package Leetcode.Arrays;

import java.util.*;

public class meetingRooms2 {
    public static int meetingRooms2(int [][]intervals) {
        if(intervals.length== 0) return 0;
        //Min Heap
//        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(
//                intervals.length, new Comparator<Integer>(){
//                    public int compare(Integer a, Integer b){
//                        return a-b;
//                    }
//        }
//        );
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
        System.out.println("Priority Queue before");
        System.out.println(pq);
        //Sorting intervals list by start time
        Arrays.sort(
          intervals, new Comparator<int[]>(){
                    public int compare(int[]a, int[]b){
                        return a[0]- b[0];
                    }
                }
        );
        System.out.println("Intervals list after sorting on starting time");
        for(int[]row: intervals){
            System.out.println(Arrays.toString(row));
        }

        // Adding first meeting
        pq.add(intervals[0][1]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>= pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        System.out.println("Priority Queue");
        System.out.println(pq);
        return pq.size();
    }
    public static void main(String[] args) {
        int intervals[][]= {{5,10},{15,20},{0,30}};
        System.out.println(meetingRooms2(intervals));
    }
}
