class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(nums[i]!=nums[i-1])){
                 int low = i+1;
            int high = nums.length-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if(sum==0){
                    while(low<high&&nums[low]==nums[low+1]){
                    low++;
                     }
                    while(low<high&&nums[high]==nums[high-1]){
                    high--;
                     }
                    result.add(Arrays.asList
                            (nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                }else if(sum<0){
                    low++;
                }else{
                    high--;
                }
            }
            }
        }
        return result;
    }
}

//V2 - Takes more time

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> res1 = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int low = i+1;
            int high = nums.length-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if(sum==0){
                    List<Integer> li = Arrays.asList(nums[i],nums[low],nums[high]);
                    res1.add(li);
                    low++;
                    high--;
                }
                else if(sum<0){
                    low++;
                }else{
                    high--;
                }
            }
        }
        List<List<Integer>> k = new ArrayList<>();
        k.addAll(res1);
        return k;
    }
}


/**
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []

*/
