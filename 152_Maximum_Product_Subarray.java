class Solution {
    public int maxProduct(int[] nums) {
      int max = Integer.MIN_VALUE;
      int temp = 0;
      for(int i=0;i<nums.length;i++){
          if(temp == 0){
              temp = nums[i];
          }else{
              temp = temp*nums[i];
          }
          max = Math.max(temp,max);
      }
     temp = 0;
        for(int i = nums.length-1;i>=0;i--){
            if(temp==0){
                temp = nums[i];
            }else{
                temp = temp*nums[i];
            }
            max = Math.max(max,temp);
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
