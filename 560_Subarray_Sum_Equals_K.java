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
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0,1);// We need to add it, because when the sum-K is zero, 
                       //its valid and increment by 1
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            if(map.containsKey(sum-k)){
                res = res+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(map);
        return res;
    }
}

// [3,4,7,11,-1,4,3] K = 7
// Map - {0=1, 3=1, 7=1, 24=1, 25=1, 28=1, 14=1, 31=1}. 
// When i=0, sum = 3, map = {3,1}, map does nt have 3-7 = -4
// When i=1, sum = 7, map = {7,1}, map has 7-7 = 0, count is 1
// When i=2, sum = 14, map = {14,1}, map has 14-7 = 7, count is 2
// When i=3, sum = 25, map = {25,1}, map does nt have 25-7 = 18
// When i=4, sum = 24, map = {24,1}, map does nt have 24-7 = 17
// When i=5, sum = 28, map = {28,1}, map does nt have 28-7 = 21
// When i=6, sum = 31, map = {31,1}, map has 31-7 = 24, count 3
// If map has sum-k element, means, last N elements sum is K.

/**
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/
