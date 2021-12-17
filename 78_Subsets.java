class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num:nums){
            int n = result.size();
            for(int i=0;i<n;i++){
                List<Integer>list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
                
            }
        }
        return result;
    }
}

----- V2 version -----
    
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(result,nums,new ArrayList<>(),0);
        return result;
    }
    public void backTracking(List<List<Integer>> result, int[] nums, List<Integer> temp,int index){
        result.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            backTracking(result,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

*/
