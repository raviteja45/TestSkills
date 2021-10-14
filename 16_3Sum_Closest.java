class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int low = i+1;
            int high= nums.length-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if(Math.abs(sum-target)<Math.abs(min-target)){
                    min = sum;
                }else if(target<sum){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return min;
    }
}

/**
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
*/
