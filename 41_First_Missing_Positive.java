class Solution {
    public int firstMissingPositive(int[] nums) {
      /**  Arrays.sort(nums);
        int count = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==count){
                count++;
            }
        }
        return count;*/
        boolean onePresent = false;
        for(int i=0;i<nums.length;i++){ // First we need to check all the numbers. If there are
                                        // any numbers outside [1,n-1], replace with "1". 
            if(nums[i]==1){
                onePresent = true;
            }
            if(nums[i]<=0||nums[i]>nums.length){
                nums[i] = 1;
            }
        }
        if(!onePresent){ // If one is not present, its the least number, return it.
            System.out.println("Inside");
            return 1;
        }
        for(int i=0;i<nums.length;i++){ 
            // Now all the elements present in the array are in [1,N]
            // Starting from first element (7), Go to index (7-1) and make that element as -ve.
            // 1,2,3 -> -1,2,3 -> -1,-2,3 -> -1,-2,-3. 
            // 3,4,-1,1 -> 3,4,-1,1(since 3-1=2, 2nd element is already -ve) -> 3,4,-1,-1                   
            // (since 4-1=3, 3rd element is 1, changed to -1) -> -3,4,-1,-1. 
            int temp = Math.abs(nums[i]);
            if(temp!=0&&nums[temp-1]>0){
                nums[temp-1] = -1*nums[temp-1];
            }
            
        }
        
        for(int i=0;i<nums.length;i++){ // Once we have above array, the first +ve element
                                        // index+1 will be answer. in -3,4,-1,-1 -> 1+1 = 2.
            if(nums[i]>0){
               return i+1;
            }
        }
        return nums.length+1; // If none above matches, it would be length+1
        
    }
}

---------------------- Not right approach since Arrays.sort has O(nlogn)
  
   /**  Arrays.sort(nums);
        int count = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==count){
                count++;
            }
        }
        return count;*/
  
/**
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1

*/
