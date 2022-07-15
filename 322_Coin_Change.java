class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
} // numbers - 1,2,5 . total - 11
           0  1  2. 3. 4. 5. 6. 7. 8. 9. 10. 11 ( amount)
  
(coins)1   0  1  2. 3. 4. 5. 6. 7. 8. 9. 10. 11 - (dp array after 1st iteration)
    
       2   0  1. 1. 2. 2. 3. 3. 4. 4. 5. 5.  6  - (dp array after 2nd iteration. column 8(dp[8-2]+1)) 
    
       5   0. 1. 1. 2. 2. 1. 2. 2. 3. 3. 2.  3(answer) - Iterations are on same array, its not 2D array


------------------------------ V2 version ---------------------------------------
               
class Solution {
    public int coinChange(int[] coins, int amount) { // Similar to Partition Equal subset sum
                                                     // Coin change 2. It uses Knapsack problem
        if(amount<=0){
            return 0;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = amount+1;
            }
            
        }
        for(int i=0;i<coins.length;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=coins[i-1]){
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-coins[i-1]]+1);
                    
                }
            }
        }
        return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];
    }
}

/**
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
*/
