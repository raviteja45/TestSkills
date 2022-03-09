class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum = sum+nums[j];
                if(sum==k){
                    result = result+1;
                }
            }
        }
        return result;
    }
}

// V2 version

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            if(map.containsKey(sum-k)){
                result = result+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return result;
    }
}

/**
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/
