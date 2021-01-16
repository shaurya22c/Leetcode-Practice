package BasicsJava;
import java.util.*;
class coinChange {

    public int coinChange(int[]coins, int amount){

        if(coins== null || coins.length== 0) return -1;

        if(amount<= 0) return 0;

        int[]dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]= 0;

        for(int i=0; i<= amount; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j]<= i){
                    dp[i]= Math.min(dp[i], 1+ dp[i-coins[j]]);
                }
            }
        }
        return dp[amount]> amount? -1: dp[amount];
    }

    public static void main(String[] args) {
        int[] coins= {1,2,5};
        int amount= 11;
        coinChange o= new coinChange();
        System.out.println(o.coinChange(coins, amount));
    }
}
