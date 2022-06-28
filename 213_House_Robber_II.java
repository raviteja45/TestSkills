class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0){
            return -1;
        }
        return Math.max(helper(nums,1,nums.length-1),helper(nums,0,nums.length-2));
    }
    
    public int helper(int[] nums, int start, int end){
        int rob1 = 0;
        int rob2 = 0;
        for(int i=start;i<=end;i++){
            int temp = Math.max(rob1+nums[i],rob2);// rob1, rob2, nums[start],nums[start+1] .. etc. Here we cant rob two houeses adjecent, so either it could be 
                                                   // rob1+nums[start] or rob2 (max between both). Next we should check rob2+nums[i+1] etc, so we are assigning
                                                   // the value of rob2 to rob1
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}

/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
*/
