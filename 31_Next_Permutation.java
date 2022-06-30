class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        for(i=nums.length-2;i>=0;i--){ // We have to check from right to left, the first 
                                       //decreasing order
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i>=0){
             int j = nums.length-1;
        while(j>=0&&nums[i]>=nums[j]){ // From right to left, find the first digit that
                                       // is greater than  ith element.
            j--;
        }
            swap(nums,i,j); // Swap both the numbers
        }
        reverse(nums,i+1); // repetitively swap all numbers from i+1 element.
    }
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums,int start){
        int end = nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}

/**
We want to find a larger number, but not too large - just the next larger one =>
We want to avoid chaning the number in the left - it will increase the number too much =>
Example: 4325413 -> we can only change the last two numbers and have 432531
What if it was 432531 in the first place? 31 cannot be increased.
Lets try 531 - still no
2531 - this can be incrased - the smallest number that can be used to incrase the 2 is 3. so for now we have 3521.
Next we want to minimize 3521 - thats easier - just sort the numbers to the right of 3 - 3125. So the unswer is 4323125 
*/
    
    

/**
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
*/
