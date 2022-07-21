class Solution {
    public int numSquares(int n) {//Its like coin change
        List<Integer> li = new ArrayList<>();
        int k = 1;
        while(n>=(k*k)){
            li.add(k*k);
            k++;
        }
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for(int coin:li){
            for(int i=coin;i<=n;i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[n];
    }
}

---------------------------v2 Version ---------------------------------
    
class Solution {
    public int numSquares(int n) {//Its like coin change
        int temp = 1;
        List<Integer> li = new ArrayList<>();
        while(temp*temp<=n){
            li.add(temp*temp);
            temp++;
        }
        int[][] dp = new int[li.size()+1][n+1];
        for(int i=0;i<=li.size();i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = n+1;
            }
        }
        for(int i=0;i<li.size();i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=li.size();i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=li.get(i-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-li.get(i-1)]+1);
                }
            }
        }
        return dp[li.size()][n];
    }
}

/**
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/
