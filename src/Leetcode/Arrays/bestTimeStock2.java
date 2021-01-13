package Leetcode.Arrays;

public class bestTimeStock2 {
    public int maxProfit(int[] prices) {
        if(prices== null || prices.length== 0) return 0;
        int profit= 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1]>prices[i]){
                profit+= prices[i+1]- prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices= {1,2,3,4,5};
        bestTimeStock2 o= new bestTimeStock2();
        System.out.println(o.maxProfit(prices));
    }
}
