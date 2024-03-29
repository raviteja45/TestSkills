class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        result.add(first);
        for(int i = 1;i<nums.length;i++){
            List<List<Integer>> currList = new ArrayList<>();
            for(List<Integer> res: result){
                for(int k=0;k<=res.size();k++){
                    List<Integer> n = new ArrayList<>(res);
                    n.add(k,nums[i]);
                    currList.add(n);
                }
            }
            result = currList;
        }
        return result;
    }
}

---- V2 Version ------

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums,result,new ArrayList<>());
        return result;
    }
    
    public void backTracking(int[]nums,List<List<Integer>> result,List<Integer> temp){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i]))
                    continue;
            temp.add(nums[i]);
            backTracking(nums,result,temp);
            temp.remove(temp.size()-1);
        }
        }       
    }
}

/**
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

*/
