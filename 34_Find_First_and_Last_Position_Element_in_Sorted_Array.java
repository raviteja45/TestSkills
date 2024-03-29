class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int left = 0;
        int right = nums.length-1;
       
        while(right>=0&&left<=nums.length-1){
            if(nums[left]==target){
                result[0] = left;
            }else{
                left++;
            }
            if(nums[right]==target){
                result[1] = right;
            }else{
                right--;
            }
            if(result[0]!=-1&&result[1]!=-1){
                break;
            }
        }
        return result;
    }
}


/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

*/
