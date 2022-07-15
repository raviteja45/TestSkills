class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum = sum+n;
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int num:nums){
            for(int i=sum;i>=num;i--){
                    dp[i] = dp[i]||dp[i-num];
                
            }
        }
        return dp[sum];
    }
}

---- To print the items, we can use backtracking ------------
  
  class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum = sum+n;
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
       List<List<Integer>> res = new ArrayList<>();
        backTracking(nums,sum,res,new ArrayList<>(),0);
        System.out.println(res);
        return false;
    }
    
    public void backTracking(int[] nums, int sum, List<List<Integer>> res, List<Integer> temp, int index){
        if(sum<0){
            return;
        }
        if(sum==0){
            res.add(new ArrayList<>(temp));
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            backTracking(nums,sum-nums[i],res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

---------------------------------------v2 version ----------------------------------------------
    
    class Solution {
    public boolean canPartition(int[] nums) { // Its similar to coin change 1 and 2. It uses knapsack problem.
        int sum = 0;
        for(int num:nums){
            sum= sum+num;
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2; // This is the target sum. Its like coin change-2, Knapsack problem.
        boolean[][] dp = new boolean[nums.length+1][sum+1];// Given nums is rows
                                                           // from 0 to sum+1 is columns.
                                                           // Rows will always be given   
                                                           //array(nums)
        for(int i=0;i<=nums.length;i++){
            dp[i][0] = true; // All rows with 0th column is true.
        }
        
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = dp[i-1][j]; // Taking from previous row, same column
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i][j]||dp[i-1][j-nums[i-1]];
 //we CANNOT reuse an element while it can be reused in Coin change-2. That is why we have dp[i-1][j-nums[i-1]] in this problem and dp[i][j-coins[i-1]] in LT518
                }
                
            }
        }
        return dp[nums.length][sum];
    }
}

/**
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

*/
