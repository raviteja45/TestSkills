public int LCS(String input1, String input2) {
			int result = 0;
			int[][] dp = new int[input1.length() + 1][input2.length() + 1];
			for (int i = 1; i <= input1.length(); i++) {
				for (int j = 1; j <= input2.length(); j++) {
					if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
						result = Integer.max(result, dp[i][j]);
					} 
				}
			}
			return result;
		}

----------------------V2 version-------------------------------------
	
public int LCS(String input1, String input2) {
		int result = 0;
		int[][] dp = new int[input1.length() + 1][input2.length() + 1];
		for (int i = 1; i <= input1.length(); i++) {
			for (int j = 1; j <= input2.length(); j++) {
				if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Integer.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return dp[input1.length()][input2.length()];
	}

/**
System.out.println(t1.LCS("abcd", "xabc")); //3

//text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

SubString - should be in sequence
*/

------------------------------To strictly follow the sequence----------------------

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                    res = Math.max(res,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return res;
    }
}

//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
