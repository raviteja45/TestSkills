class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result,new ArrayList<>(),0,nums);
        return result;
    }
    public void backTracking(List<List<Integer>> result, List<Integer> temp, int index,int[] nums){
        result.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backTracking(result,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
}


/**
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

*/
