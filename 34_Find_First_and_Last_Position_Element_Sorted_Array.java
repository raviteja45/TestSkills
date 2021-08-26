class Solution {
    public int[] searchRange(int[] nums, int target) { 
	    int[] res = {-1,-1};
        if(nums.length==0){
            return res;
        }
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;
        
    }
    public int findFirst(int[]nums, int target){
        int start = 0;
        int end = nums.length-1;
        int res = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==nums[mid]){
                res = mid;
                end = mid-1;
            }
            if(nums[mid]<target){
                start = mid+1;
            }
            if(nums[mid]>target){
                end = mid-1;
            }
        }
        return res;
    }
    
    public int findLast(int[]nums, int target){
        int start = 0;
        int end = nums.length-1;
        int res = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target==nums[mid]){
                res = mid;
                start = mid+1;
            }
            if(nums[mid]<target){
                start = mid+1;
            }
            if(nums[mid]>target){
                end = mid-1;
            }
        }
        return res;
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
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109


*/
