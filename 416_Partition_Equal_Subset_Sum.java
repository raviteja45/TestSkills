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
