class Solution {
    public int search(int[] nums, int target) {
      int start = 0;
      int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target ){
                return mid;
            }else if(nums[start]<=nums[mid]){
                if(target<=nums[mid]&&target>=nums[start]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
                
            } else if(nums[mid]<=nums[end]){
                if(target>=nums[mid]&&target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
        
    }
}


---------v2-----------

class Solution {
    public int search(int[] nums, int target) {
      int low = 0;
      int high = nums.length-1;
      while(low<=high){
          int mid = low+(high-low)/2;
          if(nums[mid]==target){
              return mid;
          }else if(nums[low]<=nums[mid]){ // Starting from low until MID, check if sub array //sorted.
              if(target>=nums[low]&&target<nums[mid]){//If above sorted, check if the target is //in between low and mid. 
                  high = mid-1;// If target is in between low and mid, move high to mid-1;
              }else{
                  low = mid+1; // if target is not in first sub array range, move low to mid+1, //which is we are going to search in next half starting from mid.
              }
          } else if(nums[mid]<=nums[high]){ // checking the next half of the array.
              if(target>=nums[mid]&&target<=nums[high]){ // target should be between mid,high. 
                  low = mid+1;//if target is between mid,high then search between mid and high. //make low is mid+1;
              }else{
                  high = mid-1;
              }
          }
      }
        return -1;
    }
}


https://www.youtube.com/watch?v=r3pMQ8-Ad5s&ab_channel=takeUforward

/**
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


*/
