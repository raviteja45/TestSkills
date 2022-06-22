class Solution {
  
  //In a sorted array, the maximum product will be either the last three largest elements or the first two (negative elements) multiplied by the last (largest) element.
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}




/**
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
*/
