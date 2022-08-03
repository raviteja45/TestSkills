class Solution { // similar to  1143. Longest Common Subsequence, but first we need to remove duplicates and then sort the new array.
    public int lengthOfLIS(int[] nums) {
       
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
                set.add(nums[i]);
        }
        int[] temp = new int[set.size()];
        int l = 0;
        for(int k:set){
            temp[l] = k;
            l++;
        }
        Arrays.sort(temp);
        int m = temp.length;
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i-1]==temp[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

/**
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/
