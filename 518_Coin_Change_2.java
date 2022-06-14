class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int j=coin;j<=amount;j++){
                    dp[j] = dp[j]+dp[j-coin];
            }
        }
        return dp[amount];
    }
}

------ v2 ------- giving time out error---- using backtracking

class Solution {
    int max = 0;
    public int change(int amount, int[] coins) {
    //List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(coins);
       backTracking(coins,amount,new ArrayList<>(),0);
        //System.out.println(result);
       return max;
    }
    
    public void backTracking(int[] cands, int target, List<Integer> temp, int index){
        if(target<0){
            return;
        }
        if(target==0){
            //result.add(new ArrayList<>(temp));
            max++;
        }
        for(int i=index;i<cands.length;i++){
            temp.add(cands[i]);
            backTracking(cands,target-cands[i],temp,i);
            temp.remove(temp.size()-1);
        }
    }
}

/**
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
*/
