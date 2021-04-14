class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> li = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            li.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++){
            if(!li.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}


/**
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]

*/
