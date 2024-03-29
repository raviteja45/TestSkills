class Solution {
    public int maxProfit(int l, int[] prices) {
        if(prices.length==0){
            return 0;
        }
       int[][] dp = new int[l+1][prices.length];
       for(int i=1;i<l+1;i++){
           int min = prices[0];
           for(int j=1;j<prices.length;j++){
               min = Math.min(min,prices[j]-dp[i-1][j-1]);
               dp[i][j] = Math.max(dp[i][j-1],prices[j]-min);
           }
       }
        return dp[l][prices.length-1];
    }
}

Version 2:

class Solution {
    public int maxProfit(int l, int[] prices) {
        if(l<=0){
            return 0;
        }
       int[] min = new int[l];
       int[] max = new int[l];
        for(int i=0;i<l;i++){
            min[i] = Integer.MAX_VALUE;
            max[i] = 0;
        }
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<l;j++){
                min[j] = Math.min(min[j],prices[i]-(j>0?max[j-1]:0));//Similar to best time to buy and sell III
                max[j] = Math.max(max[j],prices[i]-min[j]);
            }
        }
        return max[l-1];
    }
}

/**
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

*/
