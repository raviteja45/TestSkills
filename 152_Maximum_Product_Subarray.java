class Solution {
    public int maxProduct(int[] nums) {
       int left = 1;
        int right  =1;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            left = (left==0?1:left)*nums[i];
            right = (right==0?1:right)*nums[nums.length-1-i];
            max = Math.max(max,Math.max(left,right));
        }
        return max;
    }
}


/**
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/
