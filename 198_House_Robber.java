class Solution {
    public int rob(int[] nums) {
       int[] dp = new int[nums.length+1];
       dp[0] = 0;
       dp[1] = nums[0];
       for(int i=1;i<nums.length;i++){
           dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
       }
        return dp[nums.length];
    }
}

Version 2:

class Solution {
    public int rob(int[] nums) {
       int a = 0;
       int b = 0;
       for(int i=0;i<nums.length;i++){
           int opt1 = a;
           int opt2 = nums[i]+b;
           int c = Math.max(opt1,opt2);
           b = a;
           a = c;
       }
        return a;
    }
}


Version 3:

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return robHelper(nums, 0, nums.length-1);
    }
    
    public static int robHelper(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}

/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

*/
