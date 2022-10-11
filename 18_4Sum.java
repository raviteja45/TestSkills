class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> temp_res = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length-1;j++){
                int low = j+1;
                int high = nums.length-1;
                while(low<high){
                    int new_target = nums[i]+nums[low]+nums[high]+nums[j];
                    if(target == new_target){
                        temp_res.add(Arrays.asList(nums[i],nums[low],nums[high],nums[j]));
                        low++;
                        high--;
                    }else if(new_target>target){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }
        result.addAll(temp_res);
        return result;
    }
}

----------------------v2 version (above failing some test cases)---------------------------------
    
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int low = j+1;
                int high = nums.length-1;
                while(low<high){
long num = Long.valueOf(nums[i])+Long.valueOf(nums[j])+ Long.valueOf(nums[low])+ Long.valueOf(nums[high]);
                    if(num==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        set.add(temp);
                        low++;
                        high--;
                    }else if(num<target){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }
        
        res.addAll(set);
        return res;
    }
}
/**
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
*/
